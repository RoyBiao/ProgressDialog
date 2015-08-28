//: enumerated/PostOffice.java
// Modeling a post office.
package com.thinking.enumerated.demo11;
/**
 * 编程思想练习题9
 * @author ruibiao
 *
 */
import static com.thinking.util.Print.print;

import java.util.Iterator;

import com.thinking.util.Enums;

class Mail2 {
	// The NO's lower the probability of random selection:
	enum GeneralDelivery {
		YES, NO1, NO2, NO3, NO4, NO5
	}

	enum Scannability {
		UNSCANNABLE, YES1, YES2, YES3, YES4
	}

	enum Readability {
		ILLEGIBLE, YES1, YES2, YES3, YES4
	}

	enum Address {
		INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
	}

	enum ReturnAddress {
		MISSING, OK1, OK2, OK3, OK4, OK5
	}
	
	enum Forward{
		SUCCESS,FAUIL
	}
	GeneralDelivery generalDelivery;
	Scannability scannability;
	Readability readability;
	Address address;
	ReturnAddress returnAddress;
	Forward forward;
	static long counter = 0;
	long id = counter++;

	public String toString() {
		return "Mail2 " + id;
	}

	public String details() {
		return toString() + ", General Delivery: " + generalDelivery
				+ ", Address Scanability: " + scannability
				+ ", Address Readability: " + readability
				+ ", Address Address: " + address + ", Return address: "
				+ returnAddress;
	}

	// Generate test Mail2:
	public static Mail2 randomMail2() {
		Mail2 m = new Mail2();
		m.generalDelivery = Enums.random(GeneralDelivery.class);
		m.scannability = Enums.random(Scannability.class);
		m.readability = Enums.random(Readability.class);
		m.address = Enums.random(Address.class);
		m.returnAddress = Enums.random(ReturnAddress.class);
		m.forward=Enums.random(Forward.class);
		return m;
	}

	public static Iterable<Mail2> generator(final int count) {
		return new Iterable<Mail2>() {
			int n = count;

			public Iterator<Mail2> iterator() {
				return new Iterator<Mail2>() {
					public boolean hasNext() {
						return n-- > 0;
					}

					public Mail2 next() {
						return randomMail2();
					}

					public void remove() { // Not implemented
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}

public class PostOfficeEnumMap {
	enum Mail2Handler {
		GENERAL_DELIVERY {
			boolean handle(Mail2 m) {
				switch (m.generalDelivery) {
				case YES:
					print("Using general delivery for " + m);
					return true;
				default:
					return false;
				}
			}
		},
		MACHINE_SCAN {
			boolean handle(Mail2 m) {
				switch (m.scannability) {
				case UNSCANNABLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						print("Delivering " + m + " automatically");
						return true;
					}
				}
			}
		},
		VISUAL_INSPECTION {
			boolean handle(Mail2 m) {
				switch (m.readability) {
				case ILLEGIBLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						print("Delivering " + m + " normally");
						return true;
					}
				}
			}
		},
		RETURN_TO_SENDER {
			boolean handle(Mail2 m) {
				switch (m.returnAddress) {
				case MISSING:
					return false;
				default:
					print("Returning " + m + " to sender");
					return true;
				}
			}
		},
		Forward {
			@Override
			boolean handle(Mail2 m) {
				switch (m.forward) {
				case SUCCESS:
					print("Forward " + m + "sucecess");
					break;

				default:
					print("Forward " + m + "fault");
					break;
				}
				return false;
			}
		};
		abstract boolean handle(Mail2 m);
	}

	static void handle(Mail2 m) {
		for (Mail2Handler handler : Mail2Handler.values())
			if (handler.handle(m))
				return;
		print(m + " is a dead letter");
	}

	public static void main(String[] args) {
		for (Mail2 mail : Mail2.generator(30)) {
			print(mail.details());
			handle(mail);
			print("*****");
		}
	}
} /*
 * Output: Mail2 0, General Delivery: NO2, Address Scanability: UNSCANNABLE,
 * Address Readability: YES3, Address Address: OK1, Return address: OK1
 * Delivering Mail2 0 normally**** Mail2 1, General Delivery: NO5, Address
 * Scanability: YES3, Address Readability: ILLEGIBLE, Address Address: OK5,
 * Return address: OK1 Delivering Mail2 1 automatically**** Mail2 2, General
 * Delivery: YES, Address Scanability: YES3, Address Readability: YES1, Address
 * Address: OK1, Return address: OK5 Using general delivery for Mail2 2**** Mail2
 * 3, General Delivery: NO4, Address Scanability: YES3, Address Readability:
 * YES1, Address Address: INCORRECT, Return address: OK4 Returning Mail2 3 to
 * sender**** Mail2 4, General Delivery: NO4, Address Scanability: UNSCANNABLE,
 * Address Readability: YES1, Address Address: INCORRECT, Return address: OK2
 * Returning Mail2 4 to sender**** Mail2 5, General Delivery: NO3, Address
 * Scanability: YES1, Address Readability: ILLEGIBLE, Address Address: OK4,
 * Return address: OK2 Delivering Mail2 5 automatically**** Mail2 6, General
 * Delivery: YES, Address Scanability: YES4, Address Readability: ILLEGIBLE,
 * Address Address: OK4, Return address: OK4 Using general delivery for Mail2 6
 * **** Mail2 7, General Delivery: YES, Address Scanability: YES3, Address
 * Readability: YES4, Address Address: OK2, Return address: MISSING Using
 * general delivery for Mail2 7**** Mail2 8, General Delivery: NO3, Address
 * Scanability: YES1, Address Readability: YES3, Address Address: INCORRECT,
 * Return address: MISSING Mail2 8 is a dead letter**** Mail2 9, General Delivery:
 * NO1, Address Scanability: UNSCANNABLE, Address Readability: YES2, Address
 * Address: OK1, Return address: OK4 Delivering Mail2 9 normally****
 */// :~
