package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.AuthenticationBody;

public interface EmailService {
	public abstract boolean restorePassword(AuthenticationBody data);
}
