        <form method="post" action="register">
            <fieldset>
                <legend>Inscription</legend>
                <p>Formulaire d'inscription, les champs (*) sont requis :</p>

                <label for="email">Adresse e-mail <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="${form['email']}" size="20" maxlength="60" />
                <span class="erreur">${erreurs['email']}</span>
                <br />

                <label for="mdp">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="mdp" name="mdp" value="${form['mdp']}" size="20" maxlength="20" />
                <span class="erreur">${erreurs['mdp']}</span>
                <br />

                <label for="mdpConf">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="mdpConf" name="mdpConf" value="${form['mdpConf']}" size="20" maxlength="20" />
                <span class="erreur">${erreurs['mdpConf']}</span>
                <br />

                <input type="submit" value="Enregistrement" class="sansLabel" />
                <br />
                <p class="info">${actionMessage}</p>
            </fieldset>
        </form>