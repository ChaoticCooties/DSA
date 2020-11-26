import java.util.Arrays;

/** Personal implementation of the StringBuilder class */
public class StringBuilder {
  private final int START_SIZE = 16;
  private char sequence[];
  private int capacity;
  private int length = 0;

  /** Creates an empty StringBuilder with a capacity of 16 (16 empty elements). */
  public StringBuilder() {
    this.sequence = new char[START_SIZE];
    this.capacity = START_SIZE;
  }

  /**
   * Constructs a StringBuilder containing the same characters as the specified CharSequence, plus
   * an extra 16 empty elements trailing the CharSequence.
   *
   * @param cs char sequence
   */
  public StringBuilder(CharSequence cs) {
    sequence = Arrays.copyOf(cs.toString().toCharArray(), cs.length() + START_SIZE);
    this.capacity = cs.length() + START_SIZE;
  }

  /**
   * Creates a string builder whose value is initialized by the specified string, plus an extra 16
   * empty elements trailing the string.
   *
   * @param s string
   */
  public StringBuilder(String s) {
    sequence = Arrays.copyOf(s.toCharArray(), s.length() + START_SIZE);
    this.capacity = s.length() + START_SIZE;
  }

  /**
   * Creates an empty string builder with the specified initial capacity.
   *
   * @param initCapacity Initial capacity of string
   */
  public StringBuilder(int initCapacity) {
    sequence = new char[initCapacity];
    this.capacity = initCapacity;
  }

  /**
   * Sets the length of the character sequence. If newLength is less than length(), the last
   * characters in the character sequence are truncated. If newLength is greater than length(), null
   * characters are added at the end of the character sequence
   */
  public void setLength(int newLength) {
    if (newLength < length) {
      // truncate characters


    }
  }
}
