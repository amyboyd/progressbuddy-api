const coachBobID = new ObjectId();

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
	coach: new DBRef('coaches', coachBobID),
	appointments: [new DBRef('appointments', apptClaireDoctor._id)],
	lastCheckedInAt: new ISODate(),
	lastCheckedInLatitude: 53.4851305,
	lastCheckedInLongitude: -2.2401734,
	lastCheckedInDescription: 'Victoria Station, Manchester',
};
db.clients.insert(clientClaire);

const coachBob = {
	_id: coachBobID,
	name: 'Bob',
	bio: 'Bob has been working with Depaul since 2012. He studied medicine at UCL and now is a Senior Progression Coach in our Oldham center.',
	jobTitle: 'Senior Progression Coach',
	specialities : "Mental wellbeing",
	photo: '@todo',
	clients: new DBRef('clients', clientClaire._id)
};
db.coaches.insert(coachBob);

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
