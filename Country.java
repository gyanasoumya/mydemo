package taxonomy;

public class Country {
	private String countrylevel;
	private String hsbcentity;
	public String getCountrylevel() {
		return countrylevel;
	}
	public void setCountrylevel(String countrylevel) {
		this.countrylevel = countrylevel;
	}
	public String getHsbcentity() {
		return hsbcentity;
	}
	public void setHsbcentity(String hsbcentity) {
		this.hsbcentity = hsbcentity;
	}
	@Override
	public String toString() {
		return "Country [countrylevel=" + countrylevel + ", hsbcentity="
				+ hsbcentity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((countrylevel == null) ? 0 : countrylevel.hashCode());
		result = prime * result
				+ ((hsbcentity == null) ? 0 : hsbcentity.hashCode());
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
		Country other = (Country) obj;
		if (countrylevel == null) {
			if (other.countrylevel != null)
				return false;
		} else if (!countrylevel.equals(other.countrylevel))
			return false;
		if (hsbcentity == null) {
			if (other.hsbcentity != null)
				return false;
		} else if (!hsbcentity.equals(other.hsbcentity))
			return false;
		return true;
	}
	
}
