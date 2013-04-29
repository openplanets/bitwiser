package eu.scape_project.bitwiser.utils;

public class FuzzyHash { 
	/** the blocksize used by the program, */
	int blocksize;
	/** the hash for this blocksize */
	String hash;
	/** the hash for twice the blocksize, */
	String hash2;
	/** the filename. */
	String filename = null;
	
	protected FuzzyHash() {
	}

	protected FuzzyHash(int block_size, String string, String string2) {
		this.blocksize = block_size;
		this.hash = string;
		this.hash2 = string2;
		this.clean();
	}
	
	private void clean() {
		// The raw output can contain NULLs, strip them out:
		this.hash = hash.replaceAll("\0", "");
		this.hash2 = hash2.replaceAll("\0", "");		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		this.clean();
		String str =  this.blocksize + ":" + this.hash + ":" + this.hash2;
		if( this.filename != null ) {
			str += ",\""+this.filename+"\"";
		}
		return str;
	}
	
}