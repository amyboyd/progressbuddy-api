const coachBob = {
	_id: new ObjectId(),
	name: 'Bob',
	bio: 'Bob has been working with Depaul since 2012. He studied medicine at UCL and now is a Senior Progression Coach in our Oldham center.',
	jobTitle: 'Senior Progression Coach',
	photo: '@todo',
};
db.coaches.insert(coachBob);

const apptClaireDoctor = {
	_id: new ObjectId(),
	title: "Doctor's Appointment",
	durationMinutes: 60,
	dateTime: new ISODate(),
	notes: "Regular checkup for Claire",
	attended: false,
	reasonForNotAttending:  "Claire was too sick",
	appointmentType: "Doctor",
	appointmentStatus: "NOT_ATTENDED",
	appointmentPriority: "SUGGESTED"
};

db.appointments.insert(apptClaireDoctor);

const clientClaire = {
	_id: new ObjectId(),
	name: 'Claire',
	phone: '07123123123',
	address: 'Depaul Oldham',
	coach: new DBRef('coaches', coachBob._id),
	appointments: [new DBRef('appointments', apptClaireDoctor._id)]
};
db.clients.insert(clientClaire);

db.users.insert({
	email: 'coach-bob@example.com',
	password: 'pass1234',
	coach: new DBRef('coaches', coachBob._id),
});

db.users.insert({
	email: 'client-claire@example.com',
	password: 'pass1234',
	client: new DBRef('clients', clientClaire._id),
});
