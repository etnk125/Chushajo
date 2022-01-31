
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainApplication extends JFrame {

    // components
    private JLabel contentpane, playLabel, howtoLabel, quitLabel, settingLabel, creditLabel;
    private MyImageIcon backgroundImg, playImg, howtoImg, quitImg, settingImg, creditImg;
    private MyImageIcon playImgclicked, howtoImgclicked, quitImgclicked, settingImgclicked, creditImgclicked;
    // working variables 
    private int frameWidth = 1000;
    private int frameHeight = 720;
    private int playerNumber = 3;
    private int themebackground = 1, themesong = 1;
    // Next Frame
    private Game myGame;
    private SettingDialog sdialog;
    private MainApplication frame = this;
    private HowToPlayFrame h;
    private Credit c;

    public MainApplication() {
        setTitle("Menu");
        setBounds(300, 20, frameWidth, frameHeight);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(contentpane = new JLabel());
        AddComponents();
    }

    public void AddComponents() {
        backgroundImg = new MyImageIcon("picture/menu/classic/background.png").resize(frameWidth, frameHeight);
        playImg = new MyImageIcon("picture/menu/classic/play.png").resize(120, 50);
        howtoImg = new MyImageIcon("picture/menu/classic/howto.png").resize(150, 50);
        quitImg = new MyImageIcon("picture/menu/classic/quit.png").resize(120, 50);
        settingImg = new MyImageIcon("picture/menu/classic/setting.png").resize(40, 40);
        creditImg = new MyImageIcon("picture/menu/classic/credit.png").resize(40, 40);

        playImgclicked = new MyImageIcon("picture/menu/classic/playclicked.png").resize(120, 50);
        howtoImgclicked = new MyImageIcon("picture/menu/classic/howtoclicked.png").resize(150, 50);
        quitImgclicked = new MyImageIcon("picture/menu/classic/quitclicked.png").resize(120, 50);
        settingImgclicked = new MyImageIcon("picture/menu/classic/settingclicked.png").resize(40, 40);
        creditImgclicked = new MyImageIcon("picture/menu/classic/creditclicked.png").resize(40, 40);

        contentpane.setIcon(backgroundImg);
        contentpane.setLayout(null);

        playLabel = new JLabel(playImg);
        playLabel.setBounds(290, 450, 120, 50);
        contentpane.add(playLabel);
        playLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playLabel.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                MySoundEffect.entersound.playOnce();
                playLabel.setIcon(playImgclicked);
            }

            public void mouseExited(MouseEvent e) {
                playLabel.setIcon(playImg);
            }

            public void mousePressed(MouseEvent e) {
                playLabel.setIcon(playImgclicked);
                playLabel.setLocation(292, 452);
            }

            public void mouseReleased(MouseEvent e) {
                playLabel.setIcon(playImg);
                playLabel.setLocation(290, 450);
            }

            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                startGame();
                System.out.println("play");
                dispose();
            }
        });

        howtoLabel = new JLabel(howtoImg);
        howtoLabel.setBounds(420, 450, 150, 50);
        contentpane.add(howtoLabel);
        howtoLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        howtoLabel.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                MySoundEffect.entersound.playOnce();
                howtoLabel.setIcon(howtoImgclicked);
            }

            public void mouseExited(MouseEvent e) {
                howtoLabel.setIcon(howtoImg);
            }

            public void mousePressed(MouseEvent e) {
                howtoLabel.setIcon(howtoImgclicked);
                howtoLabel.setLocation(422, 452);
            }

            public void mouseReleased(MouseEvent e) {
                howtoLabel.setIcon(howtoImg);
                howtoLabel.setLocation(420, 450);
            }

            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                howToPlay();
                System.out.println("howto");
            }
        });

        quitLabel = new JLabel(quitImg);
        quitLabel.setBounds(580, 450, 120, 50);
        contentpane.add(quitLabel);
        quitLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitLabel.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                MySoundEffect.entersound.playOnce();
                quitLabel.setIcon(quitImgclicked);
            }

            public void mouseExited(MouseEvent e) {
                quitLabel.setIcon(quitImg);
            }

            public void mousePressed(MouseEvent e) {
                quitLabel.setIcon(quitImgclicked);
                quitLabel.setLocation(582, 452);
            }

            public void mouseReleased(MouseEvent e) {
                quitLabel.setIcon(quitImg);
                quitLabel.setLocation(580, 450);
            }

            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                System.out.println("quit");
                System.exit(0);
            }
        });

        settingLabel = new JLabel(settingImg);
        settingLabel.setBounds(690, 165, 40, 40);
        contentpane.add(settingLabel);
        settingLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settingLabel.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                MySoundEffect.entersound.playOnce();
                settingLabel.setIcon(settingImgclicked);
            }

            public void mouseExited(MouseEvent e) {
                settingLabel.setIcon(settingImg);
            }

            public void mousePressed(MouseEvent e) {
                settingLabel.setIcon(settingImgclicked);
                settingLabel.setLocation(692, 167);
            }

            public void mouseReleased(MouseEvent e) {
                settingLabel.setIcon(settingImg);
                settingLabel.setLocation(690, 165);
            }

            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                setting();
                System.out.println("setting");
            }
        });

        creditLabel = new JLabel(creditImg);
        creditLabel.setBounds(640, 165, 40, 40);
        contentpane.add(creditLabel);
        creditLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        creditLabel.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                MySoundEffect.entersound.playOnce();
                creditLabel.setIcon(creditImgclicked);
            }

            public void mouseExited(MouseEvent e) {
                creditLabel.setIcon(creditImg);
            }

            public void mousePressed(MouseEvent e) {
                creditLabel.setIcon(creditImgclicked);
                creditLabel.setLocation(642, 167);
            }

            public void mouseReleased(MouseEvent e) {
                creditLabel.setIcon(creditImg);
                creditLabel.setLocation(640, 165);
            }

            public void mouseClicked(MouseEvent e) {
                MySoundEffect.clicksound.playOnce();
                creditframe();
            }
        });
        repaint();
    }

    void removeLabelListener() {
        for (var i : playLabel.getMouseListeners()) {
            playLabel.removeMouseListener(i);
        }
        for (var i : howtoLabel.getMouseListeners()) {
            howtoLabel.removeMouseListener(i);
        }
        for (var i : quitLabel.getMouseListeners()) {
            quitLabel.removeMouseListener(i);
        }
        for (var i : settingLabel.getMouseListeners()) {
            settingLabel.removeMouseListener(i);
        }
        for (var i : creditLabel.getMouseListeners()) {
            creditLabel.removeMouseListener(i);
        }
    }

    public void setNewBackground(int t) {
        removeLabelListener();
        themebackground = t;
        if (themebackground >= 2) {
            backgroundImg = new MyImageIcon("picture/menu/theme/background" + (t - 1) + ".png").resize(frameWidth, frameHeight);
            playImg = new MyImageIcon("picture/menu/theme/play.png").resize(200, 120);
            howtoImg = new MyImageIcon("picture/menu/theme/howto.png").resize(345, 120);
            quitImg = new MyImageIcon("picture/menu/theme/quit.png").resize(85, 50);
            settingImg = new MyImageIcon("picture/menu/setting.png").resize(140, 50);
            creditImg = new MyImageIcon("picture/menu/theme/credit.png").resize(300, 110);

            playImgclicked = new MyImageIcon("picture/menu/theme/playclicked.png").resize(200, 120);
            howtoImgclicked = new MyImageIcon("picture/menu/theme/howtoclicked.png").resize(345, 120);
            quitImgclicked = new MyImageIcon("picture/menu/theme/quitclicked.png").resize(85, 50);
            settingImgclicked = new MyImageIcon("picture/menu/settingclicked.png").resize(140, 50);
            creditImgclicked = new MyImageIcon("picture/menu/theme/creditclicked.png").resize(300, 110);

            playLabel.setIcon(playImg);
            playLabel.setBounds(390, 220, 200, 120);
            playLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    playLabel.setIcon(playImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    playLabel.setIcon(playImg);
                }

                public void mousePressed(MouseEvent e) {
                    playLabel.setIcon(playImgclicked);
                    playLabel.setLocation(392, 222);
                }

                public void mouseReleased(MouseEvent e) {
                    playLabel.setIcon(playImg);
                    playLabel.setLocation(390, 220);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    startGame();
                    System.out.println("play");
                    dispose();
                }
            });
            howtoLabel.setIcon(howtoImg);
            howtoLabel.setBounds(330, 320, 345, 120);
            howtoLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    howtoLabel.setIcon(howtoImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    howtoLabel.setIcon(howtoImg);
                }

                public void mousePressed(MouseEvent e) {
                    howtoLabel.setIcon(howtoImgclicked);
                    howtoLabel.setLocation(332, 322);
                }

                public void mouseReleased(MouseEvent e) {
                    howtoLabel.setIcon(howtoImg);
                    howtoLabel.setLocation(330, 320);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    howToPlay();
                    System.out.println("howto");
                }
            });
            creditLabel.setIcon(creditImg);
            creditLabel.setBounds(350, 420, 300, 110);
            creditLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    creditLabel.setIcon(creditImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    creditLabel.setIcon(creditImg);
                }

                public void mousePressed(MouseEvent e) {

                    creditLabel.setIcon(creditImgclicked);
                    creditLabel.setLocation(352, 422);
                }

                public void mouseReleased(MouseEvent e) {
                    creditLabel.setIcon(creditImg);
                    creditLabel.setLocation(350, 420);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    creditframe();
                }
            });
            settingLabel.setIcon(settingImg);
            settingLabel.setBounds(400, 520, 140, 50);
            settingLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    settingLabel.setIcon(settingImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    settingLabel.setIcon(settingImg);
                }

                public void mousePressed(MouseEvent e) {

                    settingLabel.setIcon(settingImgclicked);
                    settingLabel.setLocation(402, 522);
                }

                public void mouseReleased(MouseEvent e) {
                    settingLabel.setIcon(settingImg);
                    settingLabel.setLocation(400, 520);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    setting();
                    System.out.println("setting");
                }
            });

            quitLabel.setIcon(quitImg);
            quitLabel.setBounds(800, 550, 85, 50);
            quitLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    quitLabel.setIcon(quitImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    quitLabel.setIcon(quitImg);
                }

                public void mousePressed(MouseEvent e) {

                    quitLabel.setIcon(quitImgclicked);
                    quitLabel.setLocation(802, 552);
                }

                public void mouseReleased(MouseEvent e) {
                    quitLabel.setIcon(quitImg);
                    quitLabel.setLocation(800, 550);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    System.out.println("quit");
                    System.exit(0);
                }
            });

        } else if (themebackground == 1) {
            backgroundImg = new MyImageIcon("picture/menu/classic/background.png").resize(frameWidth, frameHeight);
            playImg = new MyImageIcon("picture/menu/classic/play.png").resize(120, 50);
            howtoImg = new MyImageIcon("picture/menu/classic/howto.png").resize(150, 50);
            quitImg = new MyImageIcon("picture/menu/classic/quit.png").resize(120, 50);
            settingImg = new MyImageIcon("picture/menu/classic/setting.png").resize(40, 40);
            creditImg = new MyImageIcon("picture/menu/classic/credit.png").resize(40, 40);

            playImgclicked = new MyImageIcon("picture/menu/classic/playclicked.png").resize(120, 50);
            howtoImgclicked = new MyImageIcon("picture/menu/classic/howtoclicked.png").resize(150, 50);
            quitImgclicked = new MyImageIcon("picture/menu/classic/quitclicked.png").resize(120, 50);
            settingImgclicked = new MyImageIcon("picture/menu/classic/settingclicked.png").resize(40, 40);
            creditImgclicked = new MyImageIcon("picture/menu/classic/creditclicked.png").resize(40, 40);

            playLabel.setIcon(playImg);
            playLabel.setBounds(290, 450, 120, 50);
            playLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    playLabel.setIcon(playImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    playLabel.setIcon(playImg);
                }

                public void mousePressed(MouseEvent e) {
                    playLabel.setIcon(playImgclicked);
                    playLabel.setLocation(292, 452);
                }

                public void mouseReleased(MouseEvent e) {
                    playLabel.setIcon(playImg);
                    playLabel.setLocation(290, 450);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    startGame();
                    System.out.println("play");
                    dispose();
                }
            });
            howtoLabel.setIcon(howtoImg);
            howtoLabel.setBounds(420, 450, 150, 50);
            howtoLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    howtoLabel.setIcon(howtoImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    howtoLabel.setIcon(howtoImg);
                }

                public void mousePressed(MouseEvent e) {
                    howtoLabel.setIcon(howtoImgclicked);
                    howtoLabel.setLocation(422, 452);
                }

                public void mouseReleased(MouseEvent e) {
                    howtoLabel.setIcon(howtoImg);
                    howtoLabel.setLocation(420, 450);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    howToPlay();
                    System.out.println("howto");
                }
            });
            quitLabel.setIcon(quitImg);
            quitLabel.setBounds(580, 450, 120, 50);
            quitLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    quitLabel.setIcon(quitImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    quitLabel.setIcon(quitImg);
                }

                public void mousePressed(MouseEvent e) {
                    quitLabel.setIcon(quitImgclicked);
                    quitLabel.setLocation(582, 452);
                }

                public void mouseReleased(MouseEvent e) {
                    quitLabel.setIcon(quitImg);
                    quitLabel.setLocation(580, 450);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    System.out.println("quit");
                    System.exit(0);
                }
            });
            settingLabel.setIcon(settingImg);
            settingLabel.setBounds(690, 165, 40, 40);
            settingLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    settingLabel.setIcon(settingImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    settingLabel.setIcon(settingImg);
                }

                public void mousePressed(MouseEvent e) {
                    settingLabel.setIcon(settingImgclicked);
                    settingLabel.setLocation(692, 167);
                }

                public void mouseReleased(MouseEvent e) {
                    settingLabel.setIcon(settingImg);
                    settingLabel.setLocation(690, 165);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    setting();
                    System.out.println("setting");
                }
            });
            creditLabel.setIcon(creditImg);
            creditLabel.setBounds(640, 165, 40, 40);
            creditLabel.addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e) {
                    MySoundEffect.entersound.playOnce();
                    creditLabel.setIcon(creditImgclicked);
                }

                public void mouseExited(MouseEvent e) {
                    creditLabel.setIcon(creditImg);
                }

                public void mousePressed(MouseEvent e) {
                    creditLabel.setIcon(creditImgclicked);
                    creditLabel.setLocation(642, 167);
                }

                public void mouseReleased(MouseEvent e) {
                    creditLabel.setIcon(creditImg);
                    creditLabel.setLocation(640, 165);
                }

                public void mouseClicked(MouseEvent e) {
                    MySoundEffect.clicksound.playOnce();
                    creditframe();
                }
            });
        }
        contentpane.setIcon(backgroundImg);
        repaint();
    }

    public void howToPlay() {
        if (h == null) {
            h = new HowToPlayFrame();
        } else {
            h.UpdateHowToFrame();
            System.out.println("HowtoSetVisible");
        }
        System.out.println("how to play frame");
    }

    public void creditframe() {
        if (c == null) {
            c = new Credit();
        } else {
            c.setVisible(true);
            System.out.println("CreditSetVisible");
        }
    }

    public void setNewThemesong(int s) {
        themesong = s;

    }

    void startGame() {
        myGame = new Game( themebackground, themesong,this);
        myGame.start();

    }

    void setting() {
        if (sdialog == null) {
            sdialog = new SettingDialog(frame);
        } else {
            sdialog.setVisible(true);
            System.out.println("SettingSetVisible");
        }
    }

    public static void main(String args[]) {
        new InputPlayer();
        new MainApplication();
    }
}
