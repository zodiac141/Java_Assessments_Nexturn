
class Employee {
    private String fullName;
    private int pointLevel;
    private String assignedCategory;

    public Employee(String fullName, int pointLevel, String assignedCategory) {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.assignedCategory = assignedCategory;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPointLevel() {
        return pointLevel;
    }

    public void setPointLevel(int pointLevel) {
        this.pointLevel = pointLevel;
    }

    public String getAssignedCategory() {
        return assignedCategory;
    }

    public void setAssignedCategory(String assignedCategory) {
        this.assignedCategory = assignedCategory;
    }
}


    class Ticket {
        private int ticketId;
        private String name;
        private String category;
        private int point;
        private String AssignedEmployee;
        private boolean isCompleted;

        public Ticket(int ticketId, String name, String category, int point) {
            this.ticketId = ticketId;
            this.name = name;
            this.category = category;
            this.point = point;
            this.AssignedEmployee = "";
            this.isCompleted = false;
        }

        public int getTicketId() {
            return ticketId;
        }

        public void setTicketId(int ticketId) {
            this.ticketId = ticketId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }

        public boolean isCompleted() {
            return isCompleted;
        }
    }


    class Helpdesk {
        private Employee emp1;
        private Employee emp2;
        private Ticket t1;
        private Ticket t2;
        private Ticket t3;
        private Ticket t4;
        private Ticket t5;

        public void addEmployee(Employee e, int pos) {
            if (pos == 1) {
                emp1 = e;
            } else if (pos == 2) {
                emp2 = e;
            }
        }

        public void addTicket(Ticket t, int pos) {
            if (pos == 1) {
                t1 = t;
            } else if (pos == 2) {
                t2 = t;
            } else if (pos == 3) {
                t3 = t;
            } else if (pos == 4) {
                t4 = t;
            } else if (pos == 5) {
                t5 = t;
            }
        }

        public void completeTicket(String employeeName, int ticketId) {
            Employee employee = getEmployee(employeeName);
            if (employee != null) {
                Ticket ticket = getTicket(ticketId);
                if (ticket != null && !ticket.isCompleted()) {
                    if (employee.getPointLevel() >= ticket.getPoint()) {
                        ticket.setCompleted(true);
                        System.out.println("Ticket : " + ticketId + " marked as completed successfully by : " + employeeName);
                    } else {
                        System.out.println("Employee's point level is not sufficient to complete the ticket.");
                    }
                } else {
                    System.out.println("Ticket not found or already completed.");
                }
            } else {
                System.out.println("Employee not found.");
            }
        }

        public int getWaitingTicketCount() {
            int count = 0;
            if (t1 != null && !t1.isCompleted()) count++;
            if (t2 != null && !t2.isCompleted()) count++;
            if (t3 != null && !t3.isCompleted()) count++;
            if (t4 != null && !t4.isCompleted()) count++;
            if (t5 != null && !t5.isCompleted()) count++;
            return count;
        }

        public int getCompletedTicketsTotalPoint() {
            int totalPoint = 0;
            if (t1 != null && t1.isCompleted()) totalPoint += t1.getPoint();
            if (t2 != null && t2.isCompleted()) totalPoint += t2.getPoint();
            if (t3 != null && t3.isCompleted()) totalPoint += t3.getPoint();
            if (t4 != null && t4.isCompleted()) totalPoint += t4.getPoint();
            if (t5 != null && t5.isCompleted()) totalPoint += t5.getPoint();
            return totalPoint;
        }

        private Employee getEmployee(String employeeName) {
            if (emp1 != null && emp1.getFullName().equals(employeeName)) {
                return emp1;
            } else if (emp2 != null && emp2.getFullName().equals(employeeName)) {
                return emp2;
            }
            return null;
        }

        private Ticket getTicket(int ticketId) {
            if (t1 != null && t1.getTicketId() == ticketId) {
                return t1;
            } else if (t2 != null && t2.getTicketId() == ticketId) {
                return t2;
            } else if (t3 != null && t3.getTicketId() == ticketId) {
                return t3;
            } else if (t4 != null && t4.getTicketId() == ticketId) {
                return t4;
            } else if (t5 != null && t5.getTicketId() == ticketId) {
                return t5;
            }
            return null;
        }
    }

    public class HelpDeskSystem {
        public void main(String[] args) {
            Helpdesk helpDesk = new Helpdesk();
            Employee emp1 = new Employee("faraan", 5, "Software");
            Employee emp2 = new Employee("suisui", 8, "Hardware");

            helpDesk.addEmployee(emp1, 1);
            helpDesk.addEmployee(emp2, 2);

            Ticket t1 = new Ticket(101, "Software issue", "Software", 4);
            Ticket t2 = new Ticket(102, "network issue", "Network", 7);
            Ticket t3 = new Ticket(103, "System crash", "Hardware", 10);
            Ticket t4 = new Ticket(104, "printer not working", "Hardware", 3);
            Ticket t5 = new Ticket(105, "blue screen error", "Software", 2);

            helpDesk.addTicket(t1, 1);
            helpDesk.addTicket(t2, 2);
            helpDesk.addTicket(t3, 3);
            helpDesk.addTicket(t4, 4);
            helpDesk.addTicket(t5, 5);

            helpDesk.completeTicket("faraan", 101);
            helpDesk.completeTicket("suisui", 102);
            helpDesk.completeTicket("faraan", 103);
            helpDesk.completeTicket("suisui", 104);
            helpDesk.completeTicket("faraan", 105);

            System.out.println("Waiting ticket count: " + helpDesk.getWaitingTicketCount());
            System.out.println("Completed tickets total point: " + helpDesk.getCompletedTicketsTotalPoint());
        }
    }

