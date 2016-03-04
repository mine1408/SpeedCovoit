        <form method="post" action="register">
            <div class="form-group">
            	<div class="col-md-12">
                	<legend>Inscription</legend>
                </div>
                <div class="col-md-12">
                	Formulaire d'inscription, les champs (*) sont requis :
                </div>
                <div class="col-md-12">
                	<div class="col-md-2">
                		<label for="email">Adresse e-mail <span class="requis">*</span></label>
               		</div>
                	<div class="col-md-10">
                		<input class="form-control" type="text" id="email" name="email" value="${form['email']}" size="20" maxlength="60" />
                		<span class="erreur">${erreurs['email']}</span>
               		</div>
                </div>
                <div class="col-md-12">
                	<div class="col-md-2">
                		<label for="mdp">Mot de passe <span class="requis">*</span></label>
                	</div>
                	<div class="col-md-10">
                		<input class="form-control" type="password" id="mdp" name="mdp" value="${form['mdp']}" size="20" maxlength="20" />
                		<span class="erreur">${erreurs['mdp']}</span>
                	</div>
                </div>
                <div class="col-md-12">
                	<div class="col-md-2">
						<label for="mdpConf">Confirmation du mot de passe <span class="requis">*</span></label>
					</div>
                	<div class="col-md-10">
                		<input class="form-control" type="password" id="mdpConf" name="mdpConf" value="${form['mdpConf']}" size="20" maxlength="20" />
                		<span class="erreur">${erreurs['mdpConf']}</span>
                	</div>
                </div>
                <div class="col-md-12" style="padding-top: 10px">
                	<div class="col-md-12">                	
                		<h5 class=" bg-danger"><span style="margin-left:5px">${actionMessage}</span></h5>
                	</div>
                </div>
                <div class="col-md-12">
                	<div class="col-md-12">                	
                		<input class="btn btn-primary" type="submit" value="Enregistrement" class="sansLabel" />
                	</div>
                </div>
            </div>
        </form>