package num_17478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String question = "\"재귀함수가 뭔가요?\"";
	static String answer = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String answer2 ="마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	static String answer3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	static String ending = "라고 답변하였지.";
	
	public static void QandA(int i, int count) {
		String stick = "";
		
		stick += "_".repeat(i);
		
		System.out.println(stick + question);
		if(count == 0) {
			System.out.println(stick + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		}
		else { 
			System.out.println(stick + answer);
			System.out.println(stick + answer2);
			System.out.println(stick + answer3);
			QandA(i+4, count-1);
		}
		
		System.out.println(stick + ending);
	}
	
	public static void main(String[] args) throws IOException{
		// Answer of BaekJoon no. 17478

		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(scan.readLine());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		System.out.println(question);
		System.out.println(answer);
		System.out.println(answer2);
		System.out.println(answer3);
		
		QandA(4, count-1);
		
		System.out.println(ending);
	}

}
