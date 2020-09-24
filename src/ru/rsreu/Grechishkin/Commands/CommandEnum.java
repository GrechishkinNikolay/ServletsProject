package ru.rsreu.Grechishkin.Commands;

import ru.rsreu.Grechishkin.ActionCommand;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand(false);
		}
	},
	EXIT {
		{
			this.command = new LogoutCommand(true);
		}
	},
	HOME {
		{
			this.command = new HomeCommand(false);
		}
	},
	COMMUNITY {
		{
			this.command = new CommunityCommand(false);
		}
	},
	GETTOWORK {
		{
			this.command = new GetToWorkCommand(false);
		}
	},
	DELETETASK {
		{
			this.command = new DeleteTaskCommand(false);
		}
	},
	ADDCOMMUNITYPAGE {
		{
			this.command = new AddCommunityPageCommand(false);
		}
	},
	ADDPROJECTPAGE {
		{
			this.command = new AddProjectPageCommand(false);
		}
	},
	ADDCOMMUNITYCOMMAND {
		{
			this.command = new AddCommunityCommand(false);
		}
	},
	ADDPROJECT {
		{
			this.command = new AddProjectCommand(false);
		}
	},
	ADDTASK {
		{
			this.command = new AddTaskCommand(false);
		}
	},
	ADDTASKPAGE {
		{
			this.command = new AddTaskPageCommand(false);
		}
	},
	COMMUNITYMEMBERSPAGE {
		{
			this.command = new CommunityMembersPageCommand(false);
		}
	},
	ADDMEMBERSTOCOMMUNITY {
		{
			this.command = new AddMembersToCommunityCommand(false);
		}
	},
	DELETECOMMENT {
		{
			this.command = new DeleteCommentCommand(false);
		}
	},
	COMMUNITIES {
		{
			this.command = new CommunitiesCommand(false);
		}
	};
	ActionCommand command;
	public ActionCommand getCurrentCommand() {
		return command;
	}
}