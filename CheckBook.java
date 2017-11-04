package taxonomy;

public class CheckBook {
	private String currency;
	private String stdCheckBook;
	private String noOfStdChkBook;
	private String CstmCheckBook;
	private String isoCode;
	private String paperStmt;
	private String noOfPaperStmt;
	private String region;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStdCheckBook() {
		return stdCheckBook;
	}
	public void setStdCheckBook(String stdCheckBook) {
		this.stdCheckBook = stdCheckBook;
	}
	public String getNoOfStdChkBook() {
		return noOfStdChkBook;
	}
	public void setNoOfStdChkBook(String noOfStdChkBook) {
		this.noOfStdChkBook = noOfStdChkBook;
	}
	public String getCstmCheckBook() {
		return CstmCheckBook;
	}
	public void setCstmCheckBook(String cstmCheckBook) {
		CstmCheckBook = cstmCheckBook;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	public String getPaperStmt() {
		return paperStmt;
	}
	public void setPaperStmt(String paperStmt) {
		this.paperStmt = paperStmt;
	}
	public String getNoOfPaperStmt() {
		return noOfPaperStmt;
	}
	public void setNoOfPaperStmt(String noOfPaperStmt) {
		this.noOfPaperStmt = noOfPaperStmt;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "CheckBook [currency=" + currency + ", stdCheckBook="
				+ stdCheckBook + ", noOfStdChkBook=" + noOfStdChkBook
				+ ", CstmCheckBook=" + CstmCheckBook + ", isoCode=" + isoCode
				+ ", paperStmt=" + paperStmt + ", noOfPaperStmt="
				+ noOfPaperStmt + ", region=" + region + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((CstmCheckBook == null) ? 0 : CstmCheckBook.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
		result = prime * result
				+ ((noOfPaperStmt == null) ? 0 : noOfPaperStmt.hashCode());
		result = prime * result
				+ ((noOfStdChkBook == null) ? 0 : noOfStdChkBook.hashCode());
		result = prime * result
				+ ((paperStmt == null) ? 0 : paperStmt.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result
				+ ((stdCheckBook == null) ? 0 : stdCheckBook.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckBook other = (CheckBook) obj;
		if (CstmCheckBook == null) {
			if (other.CstmCheckBook != null)
				return false;
		} else if (!CstmCheckBook.equals(other.CstmCheckBook))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (isoCode == null) {
			if (other.isoCode != null)
				return false;
		} else if (!isoCode.equals(other.isoCode))
			return false;
		if (noOfPaperStmt == null) {
			if (other.noOfPaperStmt != null)
				return false;
		} else if (!noOfPaperStmt.equals(other.noOfPaperStmt))
			return false;
		if (noOfStdChkBook == null) {
			if (other.noOfStdChkBook != null)
				return false;
		} else if (!noOfStdChkBook.equals(other.noOfStdChkBook))
			return false;
		if (paperStmt == null) {
			if (other.paperStmt != null)
				return false;
		} else if (!paperStmt.equals(other.paperStmt))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (stdCheckBook == null) {
			if (other.stdCheckBook != null)
				return false;
		} else if (!stdCheckBook.equals(other.stdCheckBook))
			return false;
		return true;
	}
	
}
