import java.io.*;
import java.util.*;

public class HuxleyCode {
	public static void main(String[] args) {		
		String numero;
		int m;
		String comando = "";
		Scanner input = new Scanner(System.in);
		String rowValues = null;
		HashTable<String, Integer> ht = new HashTable<>();
		rowValues = input.nextLine();
		String[] elementArray = rowValues.split(" ");
		m = Integer.parseInt(elementArray[0]);
				
		while (!comando.equalsIgnoreCase("f")) {
			rowValues = input.nextLine();
			elementArray = rowValues.split(" ");
			comando = elementArray[0];
			if (elementArray.length > 1) {
				numero = elementArray[1];
			}		

			if (comando.equalsIgnoreCase("a") == true) {				
				ht.add(numero, Integer.parseInt(numero));
			}

			if (comando.equalsIgnoreCase("r") == true) {				
				ht.remove(numero);
			}

			if (comando.equalsIgnoreCase("i") == true) {
				ht.dump();
			}

		}
		input.close();

	}

	public class HashTable<K, V> implements Iterable<V> {

		// +-----------+-------------------------------------------------------
		// | Constants |
		// +-----------+

		/**
		 * The load factor for expanding the table.
		 */
		static final double LOAD_FACTOR = 0.5;

		/**
		 * The offset to use in linear probes. (We choose a prime because that helps
		 * ensure that we cover all of the spaces.)
		 */
		static final double PROBE_OFFSET = 17;

		// +--------+----------------------------------------------------------
		// | Fields |
		// +--------+

		/**
		 * The number of values currently stored in the hash table. We use this to
		 * determine when to expand the hash table.
		 */
		int size = 0;

		/**
		 * The array that we use to store the key/value pairs. (We use an array, rather
		 * than a vector, because we want to control expansion.)
		 */
		Object[] pairs;

		/**
		 * Our helpful random number generator, used primarily when expanding the size
		 * of the table..
		 */
		Random rand;

		// +--------------+----------------------------------------------------
		// | Constructors |
		// +--------------+

		/**
		 * Create a new hash table.
		 */
		public HashTable() {
			this.rand = new Random();
			this.clear();
		} // HashTable

		// +-----------+-------------------------------------------------------
		// | Observers |
		// +-----------+

		/**
		 * Determine if the hash table contains a particular key.
		 */
		public boolean containsKey(K key) throws Exception {
			// STUB/HACK
			try {
				get(key);
				return true;
			} // try
			catch (Exception e) {
				return false;
			} // try/catch
		} // containsKey(K)

		/**
		 * Dump the hash table.
		 */
		public void dump(PrintWriter pen) {
			pen.print("{");
			int printed = 0; // Number of elements printed
			for (int i = 0; i < this.pairs.length; i++) {
				@SuppressWarnings("unchecked")
				KVPair pair = (KVPair) this.pairs[i];
				if (pair != null) {
					pen.print(i + ":" + pair.key + "(" + pair.key.hashCode() + "):" + pair.value);
					if (++printed < this.size) {
						pen.print(", ");
					} // if the number printed is less than the size
				} // if the current element is not null
			} // for
			pen.println("}");
		} // dump(PrintWriter)

		/**
		 * Get the value for a particular key.
		 */
		public V get(K key) throws Exception {
			int index = find(key);
			@SuppressWarnings("unchecked")
			KVPair pair = (KVPair) pairs[index];
			if (pair == null) {
				throw new Exception("Invalid key: " + key);
			} else {
				return pair.value;
			} // get
		} // get(K)

		/**
		 * Get the size of the dictionary - the number of values stored.
		 */
		public int size() {
			return this.size;
		} // size()

		// +----------+--------------------------------------------------------
		// | Mutators |
		// +----------+

		/**
		 * Clear the whole dictionary.
		 */
		public void clear() {
			this.pairs = new Object[41];
			this.size = 0;
		} // clear()

		/**
		 * Remove a key/value pair.
		 */
		public void remove(K key) {
			// STUB
		} // remove(K)

		/**
		 * Set a value.
		 */
		public void add(K key, V value) {
			// If there are too many entries, expand the table.
			if (this.size > (this.pairs.length * LOAD_FACTOR)) {
				expand();
			} // if there are too many entries
			// Find out where the key belongs and put the pair there.
			int index = find(key);
			this.pairs[index] = new KVPair(key, value);
			// Note that we've incremented the size.
			++this.size;
		} // set(K,V)

		// +-----------+-------------------------------------------------------
		// | Iterators |
		// +-----------+

		/**
		 * Get an iterator for the values.
		 */
		public Iterator<V> iterator() {
			return new Iterator<V>() {
				public V next() {
					// STUB
					return null;
				} // next()

				public boolean hasNext() {
					// STUB
					return false;
				} // hasNext()

				public void remove() throws UnsupportedOperationException {
					throw new UnsupportedOperationException();
				} // remove()
			}; // new Iterator<V>
		} // iterator()

		// +---------+---------------------------------------------------------
		// | Helpers |
		// +---------+

		/**
		 * Expand the size of the table.
		 */
		void expand() {
			// Remember the old table.
			Object[] old = this.pairs;
			// Figure out the size of the new table.
			int newSize = 2 * this.pairs.length + rand.nextInt(10);
			// Create a new table of that size.
			// STUB
			// Move all the values from the old table to their appropriate
			// location in the new table.
			// STUB
		} // expand()

		/**
		 * Find the index of the entry with a given key. If there is no such entry,
		 * return the index of an entry we can use to store that key.
		 */
		int find(K key) {
			return Math.abs(key.hashCode()) % this.pairs.length;
		} // find(K)

		// +---------------+---------------------------------------------------
		// | Inner Classes |
		// +---------------+

		/**
		 * An easy way to hold a key/value pair.
		 */
		class KVPair {
			K key;
			V value;

			KVPair(K key, V value) {
				this.key = key;
				this.value = value;
			} // KVPair(K,V)
		} // class KVPair

	} // class HashTable<K,V>
}
