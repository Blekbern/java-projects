package my.semestral.projectxd.yump.Model;


import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * ScreenLevel class shows the design of the current screen level
 */
public class ScreenLevel {

    private ArrayList<PlatformTile> platformTiles;
    private ArrayList<Enemy> enemies;
    private ArrayList<HealthPotion> potions;
    private Player player;
    private VictoryPole pole;
    private final Logger logger = Logger.getLogger(ScreenLevel.class.getName());
    private final boolean showLogger = true;

    /**
     * Creates Screen Level instance from a file
     * @param file gets file from which it initializes its attributes from
     */
    public ScreenLevel( File file ) {
        platformTiles = new ArrayList<PlatformTile>();
        enemies = new ArrayList<Enemy>();
        potions = new ArrayList<HealthPotion>();
        initScreenLevelAttr( file );
    }

    /**
     * initializing method
     * @param file gets data for initializing class' attributes
     */
    private void initScreenLevelAttr( File file ) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file.getAbsolutePath()) );
        } catch (FileNotFoundException e) {
            logger.severe( "COULDNT FIND FILE" );
            throw new RuntimeException(e);
        }
        String line;
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
                String[] values = line.split(",");
                // platform init
                if (values[0].equals("Platform")) {
                    double x = Double.parseDouble(values[1]);
                    double y = Double.parseDouble(values[2]);
                    double width = Double.parseDouble(values[3]);
                    double height = Double.parseDouble(values[4]);

                    PlatformTile platform = new PlatformTile(x, y, width, height);
                    platformTiles.add(platform);
                }
                // normal enemy init
                if (values[0].equals("Enemy")) {
                    int health = Integer.parseInt( values[1] );
                    double x = Double.parseDouble( values[2] );
                    double y = Double.parseDouble( values[3] );
                    double width = Double.parseDouble( values[4] );
                    double height = Double.parseDouble( values[5] );
                    double movementSpeed = Double.parseDouble( values[6] );
                    int maxHealth = Integer.parseInt( values[7] );

                    Enemy enemy = new Enemy( health, x, y, width, height, movementSpeed, maxHealth );
                    enemies.add( enemy );
                }

                // jumping enemy init
                if (values[0].equals("EnemyJ")) {
                    int health = Integer.parseInt( values[1] );
                    double x = Double.parseDouble( values[2] );
                    double y = Double.parseDouble( values[3] );
                    double width = Double.parseDouble( values[4] );
                    double height = Double.parseDouble( values[5] );
                    double movementSpeed = Double.parseDouble( values[6] );
                    int maxHealth = Integer.parseInt( values[7] );
                    boolean jumping = Boolean.parseBoolean( values[8] );

                    Enemy enemy = new Enemy( health, x, y, width, height, movementSpeed, maxHealth, jumping );
                    enemies.add( enemy );
                }

                // patrolling enemy init
                if (values[0].equals("EnemyP")) {
                    int health = Integer.parseInt( values[1] );
                    double x = Double.parseDouble( values[2] );
                    double y = Double.parseDouble( values[3] );
                    double width = Double.parseDouble( values[4] );
                    double height = Double.parseDouble( values[5] );
                    double movementSpeed = Double.parseDouble( values[6] );
                    int maxHealth = Integer.parseInt( values[7] );
                    double start = Double.parseDouble( values[8] );
                    double end = Double.parseDouble( values[9] );

                    Enemy enemy = new Enemy( health, x, y, width, height, movementSpeed, maxHealth, start, end );
                    enemies.add( enemy );
                }

                // player init
                if (values[0].equals("Player")) {
                    int health = Integer.parseInt( values[1] );
                    double x = Double.parseDouble( values[2] );
                    double y = Double.parseDouble( values[3] );
                    double width = Double.parseDouble( values[4] );
                    double height = Double.parseDouble( values[5] );
                    double movementSpeed = Double.parseDouble( values[6] );
                    int maxHealth = Integer.parseInt( values[7] );

                    this.player = new Player( health, x, y, width, height, movementSpeed, maxHealth );
                }

                // potions init
                if (values[0].equals("Potion")) {
                    double x = Double.parseDouble( values[1] );
                    double y = Double.parseDouble( values[2] );
                    double width = Double.parseDouble( values[3] );
                    double height = Double.parseDouble( values[4] );

                    HealthPotion potion = new HealthPotion( x, y, width, height );
                    potions.add( potion );
                }

                // victory pole init
                if (values[0].equals("VictoryPole")) {
                    double x = Double.parseDouble( values[1] );
                    double y = Double.parseDouble( values[2] );
                    double width = Double.parseDouble( values[3] );
                    double height = Double.parseDouble( values[4] );

                    pole = new VictoryPole( x, y, width, height );
                }


            } catch (IOException e) {
                logger.severe( "COULDNT LOAD FILES" );
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Gets array list of platform tiles
     * @return ArrayList of platform tiles
     */
    public ArrayList<PlatformTile> getPlatformTiles() {
        return platformTiles;
    }

    /**
     * Gets array list of enemies
     * @return ArrayList of enemies
     */
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    /**
     * Gets player
     * @return Player instance
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets victory pole
     * @return VictoryPole instance
     */
    public VictoryPole getPole() {
        return pole;
    }

    /**
     * Sets player
     * @param player ref to player
     */
    public void setPlayer( Player player ) {
        this.player = player;
    }

    /**
     * Gets array list of potions
     * @return ArrayList of potions
     */
    public ArrayList<HealthPotion> getPotions() {
        return potions;
    }
}
