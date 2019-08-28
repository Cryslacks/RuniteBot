import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;

// 
// Decompiled by Procyon v0.5.36
// 

public class class33 extends WorldMapData
{
    static MouseWheel mouseWheel;
    HashSet field292;
    HashSet field291;
    List field290;
    
    void method550(final Buffer buffer_0, final Buffer buffer_1, final Buffer buffer_2, final int int_0, final boolean bool_0) {
        this.loadMapData(buffer_0, int_0);
        final int int_ = buffer_2.readUnsignedShort();
        this.field292 = new HashSet(int_);
        for (int int_2 = 0; int_2 < int_; ++int_2) {
            final class10 class10_0 = new class10();
            try {
                class10_0.method95(buffer_1, buffer_2);
            }
            catch (IllegalStateException illegalstateexception_0) {
                continue;
            }
            this.field292.add(class10_0);
        }
        int int_2 = buffer_2.readUnsignedShort();
        this.field291 = new HashSet(int_2);
        for (int int_3 = 0; int_3 < int_2; ++int_3) {
            final class34 class34_0 = new class34();
            try {
                class34_0.method561(buffer_1, buffer_2);
            }
            catch (IllegalStateException illegalstateexception_2) {
                continue;
            }
            this.field291.add(class34_0);
        }
        this.method551(buffer_1, bool_0);
    }
    
    void method551(final Buffer buffer_0, final boolean bool_0) {
        this.field290 = new LinkedList();
        for (int int_0 = buffer_0.readUnsignedShort(), int_2 = 0; int_2 < int_0; ++int_2) {
            final int int_3 = buffer_0.method3546();
            final Coordinates coordinates_0 = new Coordinates(buffer_0.readInt());
            final boolean bool_ = buffer_0.readUnsignedByte() == 1;
            if (bool_0 || !bool_) {
                this.field290.add(new class13(int_3, coordinates_0));
            }
        }
    }
    
    static boolean method557(final byte[] bytes_0, final int int_0, final int int_1) { // add silverstall here someplace.
        boolean bool_0 = true;
        final Buffer buffer_0 = new Buffer(bytes_0);
        int int_2 = -1;
        while (true) {
            final int int_3 = buffer_0.method3563();
            if (int_3 == 0) {
                break;
            }
            int_2 += int_3;
            int int_4 = 0;
            boolean bool_2 = false;
            while (true) {
                if (!bool_2) {
                    final int int_5 = buffer_0.getUSmart();
                    if (int_5 == 0) {
                        break;
                    }
                    int_4 += int_5 - 1;
                    final int int_6 = int_4 & 0x3F;
                    final int int_7 = int_4 >> 6 & 0x3F;
                    final int int_8 = buffer_0.readUnsignedByte() >> 2;
                    final int int_9 = int_7 + int_0;
                    final int int_10 = int_6 + int_1;
                    if (int_9 <= 0 || int_10 <= 0 || int_9 >= 103 || int_10 >= 103) {
                        continue;
                    }
                    final ObjectComposition objectcomposition_0 = FileOnDisk.getObjectDefinition(int_2);
                    if (int_8 == 22 && Game.lowMemory && objectcomposition_0.int1 == 0 && objectcomposition_0.clipType != 1 && !objectcomposition_0.obstructsGround) {
                        continue;
                    }
                    if (!objectcomposition_0.method5051()) {
                        ++Game.field635;
                        bool_0 = false;
                    }
                    bool_2 = true;
                }
                else {
                    final int int_5 = buffer_0.getUSmart();
                    if (int_5 == 0) {
                        break;
                    }
                    buffer_0.readUnsignedByte();
                }
            }
        }
        return bool_0;
    }
    
    static int method558(final int int_0, final int int_1, final int int_2) {
        final int int_3 = 256 - int_2;
        return ((int_1 & 0xFF00) * int_2 + (int_0 & 0xFF00) * int_3 & 0xFF0000) + ((int_1 & 0xFF00FF) * int_2 + int_3 * (int_0 & 0xFF00FF) & 0xFF00FF00) >> 8;
    }
    
    static void method559(final int int_0) {
        if (int_0 == -3) {
            GrandExchangeEvent.method22("Connection timed out.", "Please try using a different world.", "");
        }
        else if (int_0 == -2) {
            GrandExchangeEvent.method22("", "Error connecting to server.", "");
        }
        else if (int_0 == -1) {
            GrandExchangeEvent.method22("No response from server.", "Please try using a different world.", "");
        }
        else if (int_0 == 3) {
            class78.loginIndex = 3;
        }
        else if (int_0 == 4) {
            GrandExchangeEvent.method22("Your account has been disabled.", "Please contact a staff member for more information.", "");
        }
        else if (int_0 == 5) {
            GrandExchangeEvent.method22("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
        }
        else if (int_0 == 6) {
            GrandExchangeEvent.method22(Loader.SERVER_NAME + " has been updated!", "Please reload this page.", "");
        }
        else if (int_0 == 7) {
            GrandExchangeEvent.method22("This world is full.", "Please use a different world.", "");
        }
        else if (int_0 == 8) {
            GrandExchangeEvent.method22("Unable to connect.", "Login server offline.", "");
        }
        else if (int_0 == 9) {
            GrandExchangeEvent.method22("Login limit exceeded.", "Too many connections from your address.", "");
        }
        else if (int_0 == 10) {
            GrandExchangeEvent.method22("Unable to connect.", "Bad session interfaceHash.", "");
        }
        else if (int_0 == 11) {
            GrandExchangeEvent.method22("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
        }
        else if (int_0 == 12) {
            GrandExchangeEvent.method22("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
        }
        else if (int_0 == 13) {
            GrandExchangeEvent.method22("Could not complete login.", "Please try using a different world.", "");
        }
        else if (int_0 == 14) {
            GrandExchangeEvent.method22("The server is being updated.", "Please wait 1 minute and try again.", "");
        }
        else if (int_0 == 16) {
            GrandExchangeEvent.method22("Too many login attempts.", "Please wait a few minutes before trying again.", "");
        }
        else if (int_0 == 17) {
            GrandExchangeEvent.method22("You are standing in a members-only area.", "To play on this world move to a free area first", "");
        }
        else if (int_0 == 18) {
            GrandExchangeEvent.method22("Account locked as we suspect it has been stolen.", "Press 'recover a locked account' on front page.", "");
        }
        else if (int_0 == 19) {
            GrandExchangeEvent.method22("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
        }
        else if (int_0 == 20) {
            GrandExchangeEvent.method22("Invalid loginserver requested.", "Please try using a different world.", "");
        }
        else if (int_0 == 22) {
            GrandExchangeEvent.method22("Malformed login packet.", "Please try again.", "");
        }
        else if (int_0 == 23) {
            GrandExchangeEvent.method22("No reply from loginserver.", "Please wait 1 minute and try again.", "");
        }
        else if (int_0 == 24) {
            GrandExchangeEvent.method22("Error loading your profile.", "Please contact customer support.", "");
        }
        else if (int_0 == 25) {
            GrandExchangeEvent.method22("Unexpected loginserver response.", "Please try using a different world.", "");
        }
        else if (int_0 == 26) {
            GrandExchangeEvent.method22("This computers address has been blocked", "as it was used to break our rules.", "");
        }
        else if (int_0 == 27) {
            GrandExchangeEvent.method22("", "Service unavailable.", "");
        }
        else if (int_0 == 31) {
            GrandExchangeEvent.method22("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
        }
        else if (int_0 == 32) {
            GrandExchangeEvent.method22("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
        }
        else if (int_0 == 37) {
            GrandExchangeEvent.method22("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
        }
        else if (int_0 == 38) {
            GrandExchangeEvent.method22("You need to vote to play!", "Visit " + Loader.WEBSITE_URL + " and vote,", "and then come back here!");
        }
        else if (int_0 == 55) {
            class78.loginIndex = 8;
        }
        else {
            if (int_0 == 56) {
                GrandExchangeEvent.method22("Enter the 6-digit code generated by your", "authenticator app.", "");
                MouseInput.setGameState(11);
                return;
            }
            if (int_0 == 57) {
                GrandExchangeEvent.method22("The code you entered was incorrect.", "Please try again.", "");
                MouseInput.setGameState(11);
                return;
            }
            if (int_0 == 58) {
                GrandExchangeEvent.method22("This account has not yet been created.", "Please register it and try again.", "www." + Loader.WEBSITE_URL + "/register");
            }
            else if (int_0 == 60) {
                GrandExchangeEvent.method22("Your username is too long.", "Please register a new one and try again.", "www." + Loader.WEBSITE_URL + "/register");
            }
            else if (int_0 == 61) {
                GrandExchangeEvent.method22("This username contains bad words.", "Please register a new one and try again.", "www." + Loader.WEBSITE_URL + "/register");
            }
            else if (int_0 == 62) {
                GrandExchangeEvent.method22("This username contains invalid letters.", "Please register a new one and try again.", "www." + Loader.WEBSITE_URL + "/register");
            }
            else if (int_0 == 63) {
                GrandExchangeEvent.method22("This username is a duplicate.", "Please register a new one and try again.", "www." + Loader.WEBSITE_URL + "/register");
            }
            else if (int_0 == 64) {
                GrandExchangeEvent.method22("Your username is currently on hold.", "Please register a new one and try again.", "www." + Loader.WEBSITE_URL + "/register");
            }
            else if (int_0 == 65) {
                GrandExchangeEvent.method22("This IP address is blocked under", "suspicion of being a proxy.", "");
            }
            else if (int_0 == 66) {
                GrandExchangeEvent.method22("You are currently IP banned.", "Please contact a staff member for more information.", "");
            }
            else {
                GrandExchangeEvent.method22("Something went wrong.", "Please create a support thread for assistance.", "www." + Loader.WEBSITE_URL + "/forum");
            }
        }
        MouseInput.setGameState(10);
    }
}
