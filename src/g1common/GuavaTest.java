//package g1common;
//
//import java.util.concurrent.TimeUnit;
//
//import com.google.common.cache.Cache;
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheLoader;
//import com.google.common.cache.RemovalListener;
//import com.google.common.cache.RemovalNotification;
//
//public class GuavaTest {
//
//	public static void main(String[] args) {
//		
//	}
//	public static void use1() throws InterruptedException {
//		Cache<String, Book> cahce=CacheBuilder.newBuilder().expireAfterAccess(8, TimeUnit.SECONDS).maximumSize(10).build(new CacheLoader<String, Book>() {
//			@Override
//			public Book load(String key) throws Exception {
//				Book b=new Book();
//				return b;
//			}
//		});
//		Book b=cahce.apply("q");
//		System.out.println(b);
//		Book b2=cahce.apply("q");
//		System.out.println(b2);
//		Thread.currentThread();
//		Thread.sleep(TimeUnit.SECONDS.toMillis(10));
//		Book b3=cahce.apply("q");
//		System.out.println(b3);
//	}
//	
//	public static void use2() throws InterruptedException {
//		CacheBuilder<String, Book> cahceBuilder=CacheBuilder.newBuilder().expireAfterAccess(8, TimeUnit.SECONDS).maximumSize(1).removalListener(new RemovalListener<String, Book>() {
//			@Override
//			public void onRemoval(RemovalNotification<String, Book> rn) {
//				System.out.println(rn.getKey()+"被移除");
//			}
//		
//		});
//		Cache<String, Book> cahce=cahceBuilder.build(new CacheLoader<String, Book>() {
//			@Override
//			public Book load(String key) throws Exception {
//				Book b=new Book();
//				return b;
//			}
//		});
//		Book book_1_0=cahce.apply("book_1");//缓存book_1对象
//		System.out.println(book_1_0);
//		Book book_2_0=cahce.apply("book_2");//因为maximumSize设为1,故不能同时缓存两个或两个以上的对象,所以必须先移除之前的缓存对象book_1 再缓存book_2对象
//		System.out.println(book_2_0);
//		Book book_1_1=cahce.apply("book_1");//获取book_1 对象,如果存在则返回,否则创建新的对象,并将之缓存(book_2会被移除).
//		System.out.println(book_1_1);
//
//
//		Book book_2_1=cahce.apply("book_2");
//		System.out.println(book_2_1);//<span style="white-space: normal; background-color: #ffffff;">org.zero.resource.Book@133f1d7</span>
//		Book book_2_1_=cahce.apply("book_2");
//		System.out.println(book_2_1_);//<span style="white-space: normal; background-color: #ffffff;">org.zero.resource.Book@133f1d7</span>
//		
//	}
//	
//	
//}
