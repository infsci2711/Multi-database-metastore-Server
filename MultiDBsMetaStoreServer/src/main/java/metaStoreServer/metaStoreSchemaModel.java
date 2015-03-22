package metaStoreServer;

public class metaStoreSchemaModel {
	private int id;
	private String TBfield;
	private String TBtype;
	private String TBnull;
	private String TBkey;
	private String TBdefault;
	private String TBextra;
	
	public metaStoreSchemaModel(){
		
	}
	
	public metaStoreSchemaModel(final String TBfield, final String TBtype, final String TBnull,
			final String key, final String TBdefault, final String TBextra){
		this.setTBfield(TBfield);
		this.setTBtype(TBtype);
		this.setTBnull(TBnull);
		this.setTBkey(TBkey);
		this.setTBdefault(TBdefault);
		this.setTBextra(TBextra);
	}

	
	public metaStoreSchemaModel(final int id, final String TBfield, final String TBtype, final String TBnull,
			final String key, final String TBdefault, final String TBextra){		
		this.setId(id);
		this.setTBfield(TBfield);
		this.setTBtype(TBtype);
		this.setTBnull(TBnull);
		this.setTBkey(TBkey);
		this.setTBdefault(TBdefault);
		this.setTBextra(TBextra);
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTBfield() {
		return TBfield;
	}

	public void setTBfield(String tBfield) {
		TBfield = tBfield;
	}

	public String getTBtype() {
		return TBtype;
	}

	public void setTBtype(String tBtype) {
		TBtype = tBtype;
	}
	
	public String getTBnull() {
		return TBnull;
	}

	public void setTBnull(String tBnull) {
		TBnull = tBnull;
	}
	
	public String getTBkey() {
		return TBnull;
	}

	public void setTBkey(String tBkey) {
		TBkey = tBkey;
	}

	public String getTBdefault() {
		return TBdefault;
	}

	public void setTBdefault(String tBdefault) {
		TBdefault = tBdefault;
	}
	
	public String getTBextra() {
		return TBextra;
	}

	public void setTBextra(String tBextra) {
		TBextra = tBextra;
	}

}
