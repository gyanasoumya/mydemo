package taxonomy;
import java.util.Comparator;

	
	
	

	public class Account implements Comparable<Account>{
		private String accountType;
		private String currency;
		
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		@Override
		public String toString() {
			return "Account [accountType=" + accountType + ", currency=" + currency + "]";
		}
		
		
		@Override
		public int compareTo(Account o) {
			// TODO Auto-generated method stub
			return this.getAccountType().compareTo(o.getAccountType());
		}

	

}
