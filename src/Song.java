/*
 * @file: Song.java
 * @purpose: consists of song meta data
 */




class Song
{
        //private data members
	private String name;
	private String artist;
	private String album;
	private int year;
	private String composer;
	private String Genre;
	private boolean isBarrowable;
	private boolean permBarrow;
	private boolean isAvailable;
	private User owner;
	
	public String getName() {
		return name;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getAlbum() {
		return album;
	}
}
