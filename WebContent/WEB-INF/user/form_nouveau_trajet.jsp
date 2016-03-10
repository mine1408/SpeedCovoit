
<% boolean conducteur = true; %>
<%! 
	public void updateValueConducteur(boolean c){
		conducteur = c;
	};
%>
<button type="button" class="btn btn-lg" data-toggle="popover" data-trigger="mouseenter"
data-content="Proposer un nouveau trajet" id="conducteurButton" onclick="updateValueConducteur(true)">Conducteur</button>
<button type="button" class="btn btn-lg" data-toggle="popover" data-trigger="mouseenter"
data-content="Trouver un trajet" onclick="updateValueConducteur(false)">Passager</button>

<form method="post" action="nouveau_trajet">
            <div class="form-group">
            	<div class="col-md-12">
                	<legend>
                	<legend>
                	<% if(conducteur){ %>
						Proposer un trajet
					<%}else{ %>						
						Trouver un trajet
					<% } %>
					</legend>
					</legend>
                </div>
                <div class="col-md-12">
                	Remplissez les champs suivants (tous sont obligatoirs)
                </div>
                <div class="col-md-12">
                	Localisation
                </div>
                <div class="col-md-12">
                	<div class="col-md-2">
                		<label for="rue">Rue <span class="requis">*</span></label>
               		</div>
                	<div class="col-md-10">
                		<input class="form-control" type="text" name="rue" value="${form.rue}" size="20" maxlength="60"/>
        				<span class="erreur">${error['rue']}</span>
               		</div>
                </div>
                <div class="col-md-12">
                	<div class="col-md-2">
                		 <label for="ville">Ville <span class="requis">*</span></label>
                	</div>
                	<div class="col-md-10">
                		<input class="form-control" type="text" name="ville" value="${form.ville}" size="20" maxlength="20"/>
                	</div>
                </div>
                <div class="col-md-12">
                	Horaire
                </div>
                <div class="col-md-12">
                	<div class="col-md-2">
                		<label for="date">Date / Heure <span class="requis">*</span></label>
               		</div>
                	<div class="col-md-10">
                		<!-- Si conducteur -->
                		<% if(conducteur){ %>
               			<div class="container">
						    <div class="row">
						        <div class='col-sm-6'>
						            <div class="form-group">
						                <div class='input-group date' id='datetimepicker1'>
						                    <input type='text' class="form-control" name="date" value="${form.date}" />
						                    <span class="input-group-addon">
						                        <span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
						            </div>
						        </div>
						        <script type="text/javascript">
						            $(function () {
						                $('#datetimepicker1').datetimepicker();
						            });
						        </script>
						    </div>
						</div>
						<% } else{ %>
               			<!-- Si passager (fourchette horaire) -->
               			<div class="container">
						    <div class='col-md-5'>
						        <div class="form-group">
						            <div class='input-group date' id='datetimepicker6'>
						                <input type='text' class="form-control" name="date1" value="${form.date1}"/>
						                <span class="input-group-addon">
						                    <span class="glyphicon glyphicon-calendar"></span>
						                </span>
						            </div>
						        </div>
						    </div>
						    <div class='col-md-5'>
						        <div class="form-group">
						            <div class='input-group date' id='datetimepicker7'>
						                <input type='text' class="form-control" name="date2" value="${form.date2}" />
						                <span class="input-group-addon">
						                    <span class="glyphicon glyphicon-calendar"></span>
						                </span>
						            </div>
						        </div>
						    </div>
						</div>
						<script type="text/javascript">
						    $(function () {
						        $('#datetimepicker6').datetimepicker();
						        $('#datetimepicker7').datetimepicker({
						            useCurrent: false //Important! See issue #1075
						        });
						        $("#datetimepicker6").on("dp.change", function (e) {
						            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
						        });
						        $("#datetimepicker7").on("dp.change", function (e) {
						            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
						        });
						    });
						</script>						
					    <%} %>
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