package com.gdn.member.command.commandInterface;

import com.gdn.member.command.base.Command;
import com.gdn.member.command.model.LoginMemberCommandRequest;
import com.gdn.member.command.model.RegisterMemberCommandRequest;
import com.gdn.member.controller.webmodel.response.LoginMemberResponse;
import com.gdn.member.controller.webmodel.response.RegisterMemberResponse;

public interface LoginMemberCommand extends Command<LoginMemberCommandRequest, LoginMemberResponse> {
}
