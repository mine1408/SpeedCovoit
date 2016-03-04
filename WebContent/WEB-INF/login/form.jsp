<form method="post" action="login">
    <fieldset>
        <legend>Connexion</legend>
        <p>Vous pouvez vous connecter via ce formulaire</p>

        <label for="email">Adresse email <span class="requis">*</span></label>
        <input type="email" name="email" value="${form.email}" size="20" maxlength="60"/>
        <span class="erreur">${error['email']}</span>
        <br/>

        <label for="mdp">Mot de passe <span class="requis">*</span></label>
        <input type="password" name="mdp" value="" size="20" maxlength="20"/>
        <span class="erreur">${error['mdp']}</span>
        <br/>

        <input type="submit" value="Connexion" class="sansLabel"/>
        <br/>
        
        <p class="${statusOK ? 'succes' : 'erreur'}">${statusMessage}</p>
    </fieldset>
</form>