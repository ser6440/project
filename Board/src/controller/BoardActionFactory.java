package controller;

import controller.Action.Action;
import controller.Action.BoardCheckPassAction;
import controller.Action.BoardCheckPassFormAction;
import controller.Action.BoardDeleteAction;
import controller.Action.BoardListAction;
import controller.Action.BoardUpdateAction;
import controller.Action.BoardUpdateFormAction;
import controller.Action.BoardViewAction;
import controller.Action.BoardWriteAction;
import controller.Action.BoardWriteFormAction;
import controller.Action.ReplyDeleteAction;
import controller.Action.ReplyWriteAction;

public class BoardActionFactory {
	public static Action getAction(String command) {
		Action action = null;
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_view")) {
			action = new BoardViewAction();
		}else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		}else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		}else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		}else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}else if(command.equals("reply")) {
			action = new ReplyWriteAction();
		}else if(command.equals("replyDelete")) {
			action = new ReplyDeleteAction();
		}
		return action;
	}
}
