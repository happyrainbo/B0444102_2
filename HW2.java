import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * ID:B0444102
 * Name:�Y�H�i
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
 * �إߤ@�ӦW��cards��ArrayList<Card>
 * �إߤ@�ӦW��Deck��Constructor�A�̭����Ncards��l�ơA�M��Q�ΤT��for�j��N�P
 * 	�[�Jcards�A�Ĥ@�hfor�j�鬰�ϥΪ̿�J���X�ƵP�A�ĤG�hfor�j�鬰�P���|�ت��A
 * 	�ĤT�hfor�j�鬰�P���Q�T���I�ơA�j��̥��I�sCard��Constructor�A�Hj�Mk�ȱa�J�A
 * 	���ͦW��card���P�A�M��Ncard�o�i�P�[�Jcards��
 * �إߤ@�ӦW��printDeck��Method�A�Q��for�j��ӦL�Xcards���P�A�j��̥��I�sCard
 * 	��Constructor�A�Hcards����i���ȱa�J�A���ͦW��c���P�A�M��I�sprintCard��k�A
 * 	�Nc�o�i�P�L�X
 * �إߤ@�ӦW��getAllCards��Method�A�^�ǼƭȺ�����ArrayList<Card>�A�^�ǭȬ�cards
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
 * �ŧi���O�W��suit�Mrank���ܼơA���O�Ψ��x�s�P�����M�I��
 * �إߦW��Card��Constructor�A�Hs�Mr�Ʀr�a�J�A�Nsuit���ȳ]��s�A�Nrank���ȳ]��r
 * �إߦW��printCard��Method�A�Q��getSuit�MgetRank�Ө��osuit�Mrank���ȡA�A��
 * 	System.out.println�L�X
 * �إߦW��gerSuit��Method�A�^�ǼƭȺ�����int,�^�ǭȬ�suit
 * �إߦW��gerRank��Method�A�^�ǼƭȺ�����int,�^�ǭȬ�rank
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