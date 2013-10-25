/*
 * @file: UI.java
 * @purpose: User interface for PA2
 */

class UI
{
	private static String[][] songMeta = {
		{"name", "Funkotonic"},
		{"artist", "Funktimus Prime"}
	};
	
	private static Metadata songMeta2 = new Metadata( new String[][]{
		{"name", "Yellow Gatorade"},
		{"genre", "Gypsy Metalcore"}
	});
	
	private static String[][] songMeta3 = {
		{"name", "Cheese Strings"},
		{"artist", "Bon Anchovi"},
		{"album", "Pepper my roni"}
	};
	
	private static String[][] songMeta4 = {
		{"name", "Stairway to Heaven"},
		{"genre", "Bible"}
	};
	
	private static String[][] songMeta5 = {
		{"name", "Stairs go up"},
		{"album", "And Sometimes down"},
		{"artist", "Also has stairs"}
	};
	
    //private data members
    private User currentUser;
    
    //public data members
    public MusicManager mMngr;
    public UserManager uMngr;

	public static void main(String args[])
    {
    	UI bart = new UI();
    	
    	//Create users
    	bart.uMngr.addUser(new User("Bob", "pringles"));
    	bart.uMngr.addUser(new User("Alice", "unicrons"));
    	bart.uMngr.addUser(new User("UltralordSupreme", "galactic_conquest"));
    	
    	//Test login
    	System.out.println("Logging in as: -u Bart -p squids");
    	System.out.println(bart.doLogin("Bob", "squids"));
    	
    	System.out.println("\nLogged In? " + bart.loggedIn() + "\n");
    	
    	System.out.println("Logging in as: -u UltralordSupreme -p galactic_conquest");
    	System.out.println(bart.doLogin("UltralordSupreme", "galactic_conquest"));
    	
    	System.out.println("\nLogged In? " + bart.loggedIn() + "\n");
    	
    	//Other users
    	User Bob = bart.uMngr.findUser("Bob");
    	User Alice = bart.uMngr.findUser("Alice");
    	
    	//Add some songs to everyone's libraries
    	bart.mMngr.addSong(bart.getUser(), new Song(songMeta));
    	bart.mMngr.addSong(bart.getUser(), new Song(songMeta2));
    	bart.mMngr.addSong(bart.uMngr.findUser("Bob"), new Song(songMeta3));
    	bart.mMngr.addSong(bart.uMngr.findUser("Bob"), new Song(songMeta4));
    	bart.mMngr.addSong(bart.uMngr.findUser("Alice"), new Song(songMeta5));
    	
    	//Add some friends
    	bart.getUser().sendInvite(Bob);
    	Bob.acceptInvite(bart.getUser());
    	
    	Alice.sendInvite(bart.getUser());
    	bart.getUser().acceptInvite(Alice);
    	
    	
    	//Print logged-in user library
    	System.out.println(bart.getUser().getName() + "'s Library \n----------------------------------------");
    	
    	for (Song s : bart.getUser().getLibrary())
    		System.out.println(s);
    	
    	//Search current user library
    	System.out.println("\nSearching for Funk: \n");
    	for (Song song : bart.getUser().getLibrary().search("Funk"))
    		System.out.println(song);
    	
    	//Print friends libraries
    	System.out.println("\nFriend's Libraries \n -------------------------------------");
    	
    	for (User f : bart.getUser().getFriends()) {
    		System.out.println(f.getName());
    		
    		for (Song s : f.getLibrary())
        		System.out.println("\t" + s);
    	}
    	
    	//Search current user's friends libraries
    	System.out.println("\nSearching for Stair in friends: \n");
    	
    	for (Song song : bart.mMngr.searchFriendsMusic(bart.getUser(), "stair"))
    		System.out.println(song);
    }
    
    public UI()
    {
    	mMngr = MusicManager.instance();
    	uMngr = UserManager.instance();
    	
    	this.parseFile("config.cs314");
    }
    
    //parses input file to create users on songs
    private void parseFile(String file) //TODO
    {
    	
    }
    
    public User getUser() {
    	return this.currentUser;
    }
    
    public boolean loggedIn() {
    	if (currentUser != null) return true;
    	else return false;
    }
    
    public boolean doLogin(String username, String password) 
    {
    	User user = uMngr.findUser(username);
    	
    	if (user.checkPassword(password)) {
    		this.currentUser = user;
    		return true;
    	}
    	
    	return false;
    }
}
