import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * ID:B0444102
 * Name:嚴信虹
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N(deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/*
	 * This method is used for checking your result, not a part of your HW2
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/*
 * Description:
 * 建立一個名為cards的ArrayList<Card>
 * 建立一個名為Deck的Constructor，裡面先將cards初始化，然後利用三個for迴圈將牌
 * 	加入cards，第一層for迴圈為使用者輸入的幾副牌，第二層for迴圈為牌的四種花色，
 * 	第三層for迴圈為牌的十三種點數，迴圈裡先呼叫Card的Constructor，以j和k值帶入，
 * 	產生名為card的牌，然後將card這張牌加入cards裡
 * 建立一個名為printDeck的Method，利用for迴圈來印出cards的牌，迴圈裡先呼叫Card
 * 	的Constructor，以cards的第i項值帶入，產生名為c的牌，然後呼叫printCard方法，
 * 	將c這張牌印出
 * 建立一個名為getAllCards的Method，回傳數值種類為ArrayList<Card>，回傳值為cards
 * 
 */
class Deck{
	private ArrayList<Card> cards;
	
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int i=0;i<nDeck;i++)
		{
			for(int j=1;j<=4;j++)
			{
				for(int k=1;k<=13;k++)
				{
					Card card=new Card(j,k);
					cards.add(card);
				}
			}
		}
	}	
	
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//please implement and reuse printCard method in Card class
		for(int i=0;i<getAllCards().size();i++)
		{
			Card c=cards.get(i);
			c.printCard();
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/*
 * Description:
 * 宣告分別名為suit和rank的變數，分別用來儲存牌的花色和點數
 * 建立名為Card的Constructor，以s和r數字帶入，將suit的值設為s，將rank的值設為r
 * 建立名為printCard的Method，利用getSuit和getRank來取得suit和rank的值，再用
 * 	System.out.println印出
 * 建立名為gerSuit的Method，回傳數值種類為int,回傳值為suit
 * 建立名為gerRank的Method，回傳數值種類為int,回傳值為rank
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		System.out.println(getSuit()+","+getRank());
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}