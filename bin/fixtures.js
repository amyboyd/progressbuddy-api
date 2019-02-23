
const apptClaireDepaul = {
    // first is Depaul, 12pm Monday (i.e. 25th Feb). address: "123 Some Street, EC2A 4AB". description: "This is a one-on-one with your case-worker to discuss the changes since your last appointment and your next steps.
	_id: new ObjectId(),
	title: "Depaul one on one",
	durationMinutes: 60,
	dateTime: new ISODate("2019-02-25T12:00:00Z"),
	notes: "123 Some Street, EC2A 4AB \n \nThis is a one-on-one with your case-worker to discuss the changes since your last appointment and your next steps.",
	attended: false,
    imageURL: "https://s3.eu-west-2.amazonaws.com/faultfixers-misc/hackathon/depaul-logo.png",
	reasonForNotAttending:  "Claire was too sick",
	appointmentType: "Depaul Coaching",
	appointmentStatus: "ATTENDED",
	appointmentPriority: "MANDATORY"
};
db.appointments.insert(apptClaireDepaul);

const apptClaireCityWest = {
    _id: new ObjectId(),
    title: "CityWest Homes",
    durationMinutes: 30,
    dateTime: new ISODate("2019-02-30T16:30:00Z"),
    notes: "Westminster Council Office, SW1X \n \nThis is to discuss your living situation and to try find you permanent accommodation via the council.",
    attended: false,
    imageURL: "https://s3.eu-west-2.amazonaws.com/faultfixers-misc/hackathon/citywest-logo.jpg",
    reasonForNotAttending:  "Claire was too sick",
    appointmentType: "City West Homing",
    appointmentStatus: "NOT_ATTENDED",
    appointmentPriority: "MANDATORY"
};
db.appointments.insert(apptClaireCityWest);

const claireProgress = {
	_id: new ObjectId(),
	type: 'MOTIVATION_AND_RESPONSIBILITY',
	history: [
		{
			date: new ISODate('2019-01-07T11:48:00Z'),
			score: 5,
			comment: 'I am lazy',
		},
		{
			date: new ISODate('2019-01-01T10:00:00Z'),
			score: 2,
			comment: 'I am REALLY lazy',
		},
	]
};
db.progress.insert(claireProgress);

const claireEvent = {
	_id: new ObjectId(),
	name: "Checkin Event",
	title: "Claire updated her location!",
	bodyText: "Claire has just checked in and updated her current location. Please see if this matches up with her appointments.",
	date: new ISODate()
};
db.events.insert(claireEvent);

const clientClaire = {
	_id: new ObjectId(),
	name: 'Claire',
	phone: '07123123123',
	address: 'Depaul Oldham',
	appointments: [
	    new DBRef('appointments', apptClaireDoctor._id),
        new DBRef('appointments', apptClaireCityWest._id)
    ],
    events: [new DBRef('events', claireEvent._id)],
    progress: [new DBRef('progress', claireProgress._id)],
	lastCheckedInAt: new ISODate(),
	lastCheckedInLatitude: 53.4851305,
	lastCheckedInLongitude: -2.2401734,
	lastCheckedInDescription: 'Victoria Station, Manchester',
};
db.clients.insert(clientClaire);

const coachBob = {
	_id: new ObjectId(),
	name: 'Bob',
	bio: 'Bob has been working with Depaul since 2012. He studied medicine at UCL and now is a Senior Progression Coach in our Oldham center.',
	jobTitle: 'Senior Progression Coach',
	specialities : "Mental wellbeing",
	photo: '@todo',
	clients: [new DBRef('clients', clientClaire._id)]
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
