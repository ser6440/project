package controller;

import controller.Action.Action;
import controller.Action.HomeFormAction;
import controller.Action.JoinAction;
import controller.Action.JoinFormAction;
import controller.Action.LoginAction;
import controller.Action.LoginFormAction;
import controller.Action.LoginSuccessAction;
import controller.Action.LogoutAction;
import controller.Action.MemberCheckIdAction;
import controller.Action.MemberCheckPassAction;
import controller.Action.MemberCheckPassFormAction;
import controller.Action.MemberDeleteAction;
import controller.Action.MemberModifyAction;
import controller.Action.MemberModifyFormAction;
import controller.Action.MyInfoAction;

public class MemberActionFactory {
	public static Action getAction(String command) {
		Action action = null;
		System.out.println("command : " + command);
		if(command.equals("loginForm")) {
			action = new LoginFormAction();
		}else if(command.equals("logout")) {
			action = new LogoutAction();
		}else if(command.equals("login_check")) {
			
		}else if(command.equals("email_check")) {
			
		}else if(command.equals("CheckId")){
			action = new MemberCheckIdAction();
		}else if(command.equals("homeForm")) {
			action = new HomeFormAction();
		}else if(command.equals("joinForm")) {
			action = new JoinFormAction();
		}else if(command.equals("join")) {
			action = new JoinAction();
		}else if(command.equals("login")) {
			action = new LoginAction();
		}else if(command.equals("loginSuccess")) {
			action = new LoginSuccessAction();
		}else if(command.equals("member_delete")) {
			action = new MemberDeleteAction();
		}else if(command.equals("member_check_pass")) {
			action = new MemberCheckPassAction();
		}else if(command.equals("member_check_pass_form")) {
			action = new MemberCheckPassFormAction();
		}else if(command.equals("myInfo")) {
			action = new MyInfoAction();
		}else if(command.equals("memberModify")) {
			action = new MemberModifyAction();
		}else if(command.equals("member_update_form")) {
			action = new MemberModifyFormAction();
		}
		return action;
	}
}
