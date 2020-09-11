package logic.model;


public class Restaurant {

	private String restaurantName;
	private String restaurantOwner;
	private String restaurantType;
	private String restaurantCity;
	private String restaurantAddress;
	private int restaurantRating;
	private int restaurantBudget;
	private boolean restaurantPizza;
	private boolean restaurantSushi;
	private boolean restaurantHamburgher;
	private boolean restaurantPasta;
	private boolean restaurantMeat;
	private boolean restaurantVegan;
	private boolean restaurantFish;
	private boolean restaurantGourmet;
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String name) {
		this.restaurantName = name;
	}
	public String getRestaurantOwner() {
		return restaurantOwner;
	}
	public void setRestaurantOwner(String owner) {
		this.restaurantOwner = owner;
	}
	public String getRestaurantType() {
		return restaurantType;
	}
	public void setRestaurantType(String type) {
		this.restaurantType = type;
	}
	public String getRestaurantCity() {
		return restaurantCity;
	}
	public void setRestaurantCity(String city) {
		this.restaurantCity = city;
	}
	public String getAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String address) {
		this.restaurantAddress = address;
	}
	public int getRestaurantRating() {
		return restaurantRating;
	}
	public void setRestaurantRating(int rating) {
		this.restaurantRating = rating;
	}

	public int getRestaurantBudget() {
		return restaurantBudget;
	}
	public void setRestaurantBudget(int budget) {
		this.restaurantBudget = budget;
	}
	public boolean isRestaurantPizza() {
		return restaurantPizza;
	}
	public void setRestaurantPizza(boolean pizza) {
		this.restaurantPizza = pizza;
	}
	public boolean isRestaurantSushi() {
		return restaurantSushi;
	}
	public void setRestaurantSushi(boolean sushi) {
		this.restaurantSushi = sushi;
	}
	public boolean isRestaurantHamburgher() {
		return restaurantHamburgher;
	}
	public void setRestaurantHamburgher(boolean hamburgher) {
		this.restaurantHamburgher = hamburgher;
	}
	public boolean isRestaurantPasta() {
		return restaurantPasta;
	}
	public void setRestaurantPasta(boolean pasta) {
		this.restaurantPasta = pasta;
	}
	public boolean isRestaurantMeat() {
		return restaurantMeat;
	}
	public void setRestaurantMeat(boolean meat) {
		this.restaurantMeat = meat;
	}
	public boolean isRestaurantVegan() {
		return restaurantVegan;
	}
	public void setRestaurantVegan(boolean vegan) {
		this.restaurantVegan = vegan;
	}
	public boolean isRestaurantFish() {
		return restaurantFish;
	}
	public void setRestaurantFish(boolean fish) {
		this.restaurantFish = fish;
	}
	public boolean isRestaurantGourmet() {
		return restaurantGourmet;
	}
	public void setRestaurantGourmet(boolean gourmet) {
		this.restaurantGourmet = gourmet;
	}
}
