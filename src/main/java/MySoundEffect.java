
import java.net.MalformedURLException;

class MySoundEffect {

    private java.applet.AudioClip audio;

    static MySoundEffect clicksound = new MySoundEffect("music/Mouseclick.wav");
    static MySoundEffect entersound = new MySoundEffect("music/Mouseenter.wav");
    static MySoundEffect carmovesound = new MySoundEffect("music/Carmove.wav");
    static MySoundEffect carrollsound = new MySoundEffect("music/Carroll.wav");
    static MySoundEffect dicerollsound = new MySoundEffect("music/Diceroll.wav");
    static MySoundEffect endgamesound = new MySoundEffect("music/Endgame.wav");
    static MySoundEffect christmassound = new MySoundEffect("music/theme/christmassong.wav");
    static MySoundEffect classicsound = new MySoundEffect("music/theme/classicsong.wav");
    static MySoundEffect farmersound = new MySoundEffect("music/theme/farmersong.wav");
    static MySoundEffect forestsound = new MySoundEffect("music/theme/forestsong.wav");
    static MySoundEffect oceansound = new MySoundEffect("music/theme/oceansong.wav");
    static MySoundEffect snowsound = new MySoundEffect("music/theme/snowlandsong.wav");

    public MySoundEffect(String filename) {
        Thread fileThread = new Thread() {
            public void run() {

                java.io.File file = new java.io.File(filename);
                try {
                    audio = java.applet.Applet.newAudioClip(file.toURL());
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
                System.out.println(file);
            }
        };
        fileThread.start();
        try {
            fileThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public MySoundEffect() {
    }

    public void playOnce() {
        Thread onceThread = new Thread() {
            public void run() {

                audio.stop();
                audio.play();
            }
        };
        onceThread.start();

    }

    public void playLoop() {

        Thread loopThread = new Thread() {
            public void run() {
                audio.loop();
            }
        };
        loopThread.start();
    }

    public void stop() {
        audio.stop();
    }
}
