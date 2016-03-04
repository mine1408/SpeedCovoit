<form method="post" action="login">
            <div class="form-group">
            	<div class="col-md-12">
                	<legend>Connexion</legend>
                </div>
                <div class="col-md-12">
                	Vous pouvez vous connecter via ce formulaire
                </div>
                <div class="col-md-12">
                	<div class="col-md-2">
                		<label for="nom">Adresse email <span class="requis">*</span></label>
               		</div>
                	<div class="col-md-10">
                		<input class="form-control" type="email" name="email" value="${form.email}" size="20" maxlength="60"/>
        				<span class="erreur">${error['email']}</span>
               		</div>
                </div>
                <div class="col-md-12">
                	<div class="col-md-2">
                		 <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                	</div>
                	<div class="col-md-10">
                		<input class="form-control" type="password" name="mdp" value="" size="20" maxlength="20"/>
                	</div>
                </div>
                <div class="col-md-12" style="padding-top: 10px">
                	<div class="col-md-12">                	
                	<p class="${statusOK ? 'succes' : 'erreur'}">${statusMessage}</p>
                	</div>
                </div>
                <div class="col-md-12">
                	<div class="col-md-12">                	
                		<input type="submit" value="Connexion" class="sansLabel"/>
                	</div>
                </div>
            </div>
</form>