package pixelmon.entities.pixelmon;

import java.util.ArrayList;
import java.util.Random;

import pixelmon.WorldHelper;
import pixelmon.battles.BattleController;
import pixelmon.battles.Moveset;
import pixelmon.battles.attacks.statusEffects.StatusEffectBase;
import pixelmon.battles.participants.IBattleParticipant;
import pixelmon.battles.participants.PlayerParticipant;
import pixelmon.battles.participants.TrainerParticipant;
import pixelmon.battles.participants.WildPixelmonParticipant;
import pixelmon.comm.ChatHandler;
import pixelmon.database.BattleStats;
import pixelmon.database.DatabaseMoves;
import pixelmon.database.DatabaseStats;
import pixelmon.database.PixelmonIVStore;
import pixelmon.database.Stats;
import pixelmon.entities.EntityTrainer;
import pixelmon.entities.pixelmon.helpers.IHaveHelper;
import pixelmon.entities.pixelmon.helpers.LevelHelper;
import pixelmon.entities.pixelmon.helpers.PixelmonEntityHelper;
import pixelmon.enums.EnumType;
import pixelmon.storage.PokeballManager;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAITasks;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityWaterMob;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;
import net.minecraft.src.mod_Pixelmon;

public abstract class EntityWaterPixelmon extends EntityTameableWaterPokemon implements IHaveHelper {
	public String name;
	public String nickname = "";
	public float scale = 1F;
	public float maxScale = 1.25F;
	public LevelHelper lvl;
	public ArrayList<EnumType> type = new ArrayList<EnumType>();
	public Moveset moveset = new Moveset();
	public double caughtBall = 0;
	public boolean isInBall = true;
	public Stats stats = new Stats();
	public boolean isFainted = false;
	public BattleStats battleStats = new BattleStats();
	public ArrayList<StatusEffectBase> status = new ArrayList<StatusEffectBase>();
	public BattleController bc;
	private float field_21080_l;
	public float swimFrequency = 0.6f;
	public float swimSpeed = 1.5f;
	public float decayRate = 0.99f;
	public int refreshRate = 100;
	protected int depthRangeStart=0;
	protected int depthRangeEnd=100;
	private boolean isSwimming = true;
	public boolean isMale;
	public PixelmonEntityHelper helper = new PixelmonEntityHelper(this);

	public EntityWaterPixelmon(World par1World) {
		super(par1World);
		setSize(0.5f, 0.5f);
		stats.IVs = PixelmonIVStore.CreateNewIVs();
		dataWatcher.addObject(19, -1);
		dataWatcher.addObject(20, (short) 0);
	}

	public Stats getStats() {
		return stats;
	}

	public void init() {
		if ((new Random()).nextFloat() < 1 / 8192f) {
			System.out.println("Shiny " + name + " spawned");
			dataWatcher.updateObject(20, (short) 1);
		}
		dataWatcher.addObject(18, "");
		stats.BaseStats = DatabaseStats.GetBaseStats(name);
		type.add(stats.BaseStats.Type1);
		if (stats.BaseStats.Type2 != EnumType.Mystery)
			type.add(stats.BaseStats.Type2);
		health = 10;
		if (rand.nextInt(100) < stats.BaseStats.MalePercent)
			isMale = true;
		else
			isMale = false;
		setSize(stats.BaseStats.Height, width);
		helper.getLvl();
		this.field_21080_l = 1.0F / (this.rand.nextFloat() + 1.0F) * swimFrequency;
	}

	public void loadMoveset() {
		moveset = DatabaseMoves.GetInitialMoves(name, helper.getLvl().getLevel());
	}

	public void StartBattle(PixelmonEntityHelper target) {
		if (this.moveset.size() == 0)
			loadMoveset();

		IBattleParticipant p1, p2;
		if (getOwner() != null)
			p1 = new PlayerParticipant(getOwner(), helper);
		else
			p1 = new WildPixelmonParticipant(helper);

		if (target.getOwner() != null)
			p2 = new PlayerParticipant(target.getOwner(), target);
		else
			p2 = new WildPixelmonParticipant(target);

		bc = new BattleController(p1, p2);
		tasks = new EntityAITasks();
	}

	public void StartBattle(EntityTrainer trainer, EntityPlayer opponent) {
		if (this.moveset.size() == 0)
			loadMoveset();
		IBattleParticipant p1, p2;
		if (getOwner() != null)
			p1 = new PlayerParticipant(getOwner(), helper);
		else
			p1 = new WildPixelmonParticipant(helper);

		p2 = new TrainerParticipant(trainer, opponent);

		bc = new BattleController(p1, p2);
		tasks = new EntityAITasks();
	}

	protected boolean isValidTarget(Entity entity) {
		return helper.isValidTarget(entity);
	}

	@Override
	public void SetBattleController(BattleController battleController) {
		this.bc = battleController;
		if (this.moveset.size() == 0)
			loadMoveset();
		isSwimming = false;
	}

	@Override
	public void EndBattle() {
		bc = null;
		isSwimming = true;
	}

	public boolean interact(EntityPlayer entity) {
		return helper.interact(entity);
	}

	public void onDeath(DamageSource damagesource) {
		super.onDeath(damagesource);
		if (getOwner() != null) {
			String s = "Your " + helper.getName() + " fainted!";
			ChatHandler.sendChat(getOwner(), s);
			isFainted = true;
			health = 0;
			catchInPokeball();
		} else {
			super.onDeath(damagesource);
			this.setDead();
			this.onEntityDeath();
		}
	}

	public void setHealth(int i) {
		health = i;
	}

	float randomMotionSpeed;
	float randomMotionVecX;
	float randomMotionVecY;
	float randomMotionVecZ;
	private float field_21085_g;

	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (!isSwimming) {
			motionX = motionY = motionZ = 0;
			return;
		}
		this.field_21085_g += this.field_21080_l;
		if (this.field_21085_g > ((float) Math.PI * 2F)) {
			this.field_21085_g -= ((float) Math.PI * 2F);
		}
		if (this.isInWater()) {
			if (randomMotionSpeed <= swimSpeed / 2)
				randomMotionSpeed = swimSpeed;
			randomMotionSpeed *= decayRate;

			if (!worldObj.isRemote) {
				motionX = randomMotionVecX * randomMotionSpeed;
				motionY = randomMotionVecY * randomMotionSpeed * 0.05;
				motionZ = randomMotionVecZ * randomMotionSpeed;
			}

			renderYawOffset += ((-(float) Math.atan2(motionX, motionZ) * 180F) / (float) Math.PI - renderYawOffset) * 0.1F;
			rotationYaw = renderYawOffset;
		} else {
			surfaceHeight = this.posY;
			this.motionX = 0.0D;
			this.motionY -= 0.08D;
			this.motionY *= 0.9800000190734863D;
			this.motionZ = 0.0D;
		}
	}

	double surfaceHeight = 1000;

	protected void fall(float f) {
		if (!this.isInWater()) {
			super.fall(f);
		}
	}

	public void moveEntityWithHeading(float par1, float par2) {
		super.moveEntityWithHeading((float) motionX, (float) motionZ);
		// moveEntity(motionX, motionY, motionZ);
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	int count = 0;
	public EntityTrainer trainer;
	private String ownerName;

	protected void updateEntityActionState() {
		if (count == 0) {
			int wdepth = WorldHelper.getWaterDepth((int)posX, (int)posY, (int)posZ, worldObj);
			// if (rand.nextInt(90) == 0 || randomMotionVecX == 0.0F
			// && randomMotionVecY == 0.0F && randomMotionVecZ == 0.0F) {
			count = refreshRate - refreshRate / 2 + rand.nextInt(refreshRate / 2);
			randomMotionVecX = (-0.5f + rand.nextFloat()) * 0.2F;
			if (wdepth >= depthRangeEnd)
				randomMotionVecY = (0.02F + rand.nextFloat()) * 0.1F;
			else if (wdepth <= depthRangeStart)
				randomMotionVecY = (-0.02F + rand.nextFloat()) * 0.1F;
			else
				randomMotionVecY = rand.nextFloat() * 0.1F;
			randomMotionVecZ = (-0.5f + rand.nextFloat()) * 0.2F;
		}
		count--;

		despawnEntity();
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	public boolean getCanSpawnHere() {
		int wdepth= WorldHelper.getWaterDepth((int)posX, (int)posY, (int)posZ, worldObj);
		if ( wdepth >= depthRangeStart && wdepth < depthRangeEnd) return true;
		return false;
	}

	public abstract void evolve();

	protected void evolve(PixelmonEntityHelper entity) {
		helper.evolve(entity);
	}

	public void catchInPokeball() {
		mod_Pixelmon.pokeballManager.getPlayerStorage(getOwner()).updateNBT(helper);
		isInBall = true;
		unloadEntity();
	}

	public void unloadEntity() {
		ArrayList<Entity> list = new ArrayList<Entity>();
		list.add(this);
		worldObj.unloadEntities(list);
		clearAttackTarget();
		if (bc != null) {
			bc = null;
		}
	}

	public int getMaxHealth() {
		if (stats == null)
			return 1;
		return stats.HP;
	}

	public void releaseFromPokeball() {
		worldObj.spawnEntityInWorld(this);
		isInBall = false;
	}

	public void setMotion(int i, int j, int k) {
		motionX = i;
		motionY = j;
		motionZ = k;
	}

	public void clearAttackTarget() {
		setTarget(null);
		setAttackTarget(null);
	}

	public void writeEntityToNBT(NBTTagCompound var1) {
		if (getPokemonId() < -1)
			return;
		super.writeEntityToNBT(var1);
		helper.writeToNBT(var1);
	}

	boolean isStorage = false;

	public void writeEntityToStorageNBT(NBTTagCompound var1) {
		isStorage = true;
		writeEntityToNBT(var1);
		isStorage = false;
	}

	public void readEntityFromNBT(NBTTagCompound var1) {
		super.readEntityFromNBT(var1);
		helper.readFromNBT(var1);
	}

	public void setLocationAndAngles(IHaveHelper currentPixelmon) {
		if (currentPixelmon instanceof BaseEntityPixelmon) {
			this.posX = ((BaseEntityPixelmon) currentPixelmon).posX;
			this.posY = ((BaseEntityPixelmon) currentPixelmon).posY;
			this.posZ = ((BaseEntityPixelmon) currentPixelmon).posZ;
		} else if (currentPixelmon instanceof EntityWaterPixelmon) {
			this.posX = ((EntityWaterPixelmon) currentPixelmon).posX;
			this.posY = ((EntityWaterPixelmon) currentPixelmon).posY;
			this.posZ = ((EntityWaterPixelmon) currentPixelmon).posZ;
		}
	}

	public PixelmonEntityHelper getHelper() {
		return helper;
	}

	public void onUpdate() {
		if (bc != null) {
			if (bc.participant1.currentPokemon() == helper)
				bc.update();
		}
		super.onUpdate();
	}

	public EntityPlayer getOwner() {
		if (ownerName == null)
			return null;
		return worldObj.getPlayerEntityByName(ownerName);
	}

	public void setOwner(EntityPlayer owner) {
		ownerName = owner.username;
	}

	public void setLvlString(String string) {
		dataWatcher.updateObject(18, string);
	}

	public int getPokemonId() {
		return dataWatcher.getWatchableObjectInt(19);
	}

	public void setPokemonId(int id) {
		dataWatcher.updateObject(19, id);
	}
	
	public boolean getIsShiny() {
		return dataWatcher.getWatchableObjectShort(20) == 1;
	}

	public void setIsShiny(boolean isShiny) {
		if (isShiny)
			dataWatcher.updateObject(20, (short) 1);
		else
			dataWatcher.updateObject(20, (short) 0);
	}
}
