package team.javaSpirit.teachingAssistantPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 学生小测映射，状态0表示没有答题，状态1表示已答题可以查看答案
* <p>Title: StudentQuiz</p>
* <p>Description: </p>
* @author renyuyuan
* @date 2019年5月28日
 */
@Entity
@Table(name="studentquiz")
public class StudentQuiz {
	private int id;
	private Students student;
	private Quiz quiz;
	private int state;
	private float acc;
	private float time;
	private String answer;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "sid")
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	@ManyToOne
	@JoinColumn(name = "quizid")
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public float getAcc() {
		return acc;
	}
	public void setAcc(float acc) {
		this.acc = acc;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
