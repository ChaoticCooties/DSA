import java.util.Arrays;

/**
 * Personal implementation of the StringBuilder class No error checks are implemented since this is
 * just an exercise on how StringBuilder works. Not all overloaded insert/append methods are added
 * either as they are redundant.
 */
public class StringBuilder {
  private final int START_SIZE = 16;
  private final double BUFFER_MULTIPLIER = 1.5;
  private char value[];
  private int capacity;
  private int length = 0;

  /** Creates an empty StringBuilder with a capacity of 16 (16 empty elements). */
  public StringBuilder() {
    this.value = new char[START_SIZE];
    this.capacity = START_SIZE;
  }

  /**
   * Constructs a StringBuilder containing the same characters as the specified CharSequence, plus
   * an extra 16 empty elements trailing the CharSequence.
   *
   * @param cs char value
   */
  public StringBuilder(CharSequence cs) {
    value = Arrays.copyOf(cs.toString().toCharArray(), cs.length() + START_SIZE);
    this.capacity = cs.length() + START_SIZE;
  }

  /**
   * Creates a string builder whose value is initialized by the specified string, plus an extra 16
   * empty elements trailing the string.
   *
   * @param s string
   */
  public StringBuilder(String s) {
    value = Arrays.copyOf(s.toCharArray(), s.length() + START_SIZE);
    this.capacity = s.length() + START_SIZE;
  }

  /**
   * Creates an empty string builder with the specified initial capacity.
   *
   * @param initCapacity Initial capacity of string
   */
  public StringBuilder(int initCapacity) {
    value = new char[initCapacity];
    this.capacity = initCapacity;
  }

  /**
   * Ensures that the capacity is at least equal to the specified minimum.
   *
   * @param minCapacity the minimum capacity
   */
  private void ensureCapacity(int minCapacity) {
    // new capacity bigger than current capacity
    if (minCapacity - capacity > 0) {
      int newCapacity = (int) (minCapacity * BUFFER_MULTIPLIER);
      value = Arrays.copyOf(value, minCapacity * newCapacity);
      capacity = newCapacity;
    }
  }

  /**
   * Sets the length of the character value. If newLength is less than length(), the last characters
   * in the character value are truncated. If newLength is greater than length(), null characters
   * are added at the end of the character value
   */
  private void setLength(int newLength) {
    ensureCapacity(newLength);
    if (newLength > length) {
      Arrays.fill(value, length, newLength, (char) 0);
    }
  }

  /**
   * Appends the argument to this string builder. The data is converted to a string before the
   * append operation takes place.
   *
   * @param b Boolean value to be appended into StringBuilder
   */
  public void append(boolean b) {
    String appendValue = b ? "true" : "false";
    internalAppend(appendValue);
  }

  /**
   * Appends the argument to this string builder. The data is converted to a string before the
   * append operation takes place.
   *
   * @param c Character to be appended into StringBuilder
   */
  public void append(char c) {
    String appendValue = String.valueOf(c);
    internalAppend(appendValue);
  }

  /**
   * Appends the argument to this string builder. The data is converted to a string before the
   * append operation takes place.
   *
   * @param str String to be appended into StringBuilder
   */
  public void append(String str) {
    internalAppend(str);
  }

  /**
   * Private helper function for all append functions
   *
   * @param str string in char array representation to be appended into value array
   */
  private void internalAppend(String str) {
    char[] newValue = str.toCharArray();
    ensureCapacity(length + str.length());

    // add to value array
    for (char character : newValue) {
      value[length++] = character;
    }

    // update current length
    length += str.length();
  }

  /**
   * deletes the subsequence from start to end-1 (inclusive) in the StringBuilder's char sequence
   *
   * @param start Start index
   * @param end End index (inclusive)
   */
  public void delete(int start, int end) {
    for (int i = start; i <= end; i++) {
      value[i] = (char) 0;
    }
  }

  /**
   * deletes the character located at index.
   *
   * @param index char's index to be deleted
   */
  public void deleteCharAt(int index) {
    value[index] = (char) 0;
  }

  /**
   * Inserts the second argument into the string builder.
   *
   * @param offset Indicates the index before which the data is to be inserted
   * @param b converted to string before insertion
   */
  public void insert(int offset, boolean b) {
    String appendValue = b ? "true" : "false";
    internalInsert(offset, appendValue);
  }

  /**
   * Inserts the second argument into the string builder.
   *
   * @param offset Indicates the index before which the data is to be inserted
   * @param str to be passed into insertion
   */
  public void insert(int offset, String str) {
    internalInsert(offset, str);
  }

  /**
   * Private helper function for the insert function
   *
   * @param offset The offset location for the string to be placed
   * @param str To be inserted into the array
   */
  private void internalInsert(int offset, String str) {
    ensureCapacity(offset + str.length());

    char[] newValue = str.toCharArray();

    System.arraycopy(newValue, 0, value, offset, newValue.length);

    length = offset + str.length();
  }

  /**
   * Replaces the specified character(s) in this string builder.
   *
   * @param start The start index in which the specified characters are replaced
   * @param end The end index in which the specified characters are replaced (inclusive)
   * @param s The value used for replacement
   */
  public void replace(int start, int end, String s) {
    if (end > length) {
      throw new ArrayIndexOutOfBoundsException("end index is longer than current length");
    }

    char[] newValue = s.toCharArray();

    System.arraycopy(newValue, 0, value, start, end - start + 1);
  }

  /**
   * Replaces the specified character(s) in this string builder.
   *
   * @param c character to be replaced with
   */
  public void setCharAt(int index, char c) {
    value[index] = c;
  }

  /** Reverses the sequence in StringBuilder in place. */
  public void reverse() {
    for (int i = 0; i < value.length / 2; i++) {
      char temp = value[i];
      value[i] = value[value.length - i - 1];
      value[value.length - i - 1] = temp;
    }
  }

  /**
   * Returns a string that contains the character sequence in the builder.
   * @return String that contains the character sequence in StringBuilder.
   */
  public String toString() {
      return Arrays.toString(value);
  }
}
