package org.crysil.gatekeeperwithsessions.configuration;

/**
 * The Interface AuthenticationPeriod.
 */
public interface AuthenticationPeriod {
    /**
     * Checks if the period is still valid.
     *
     * @return true, if valid
     */
    public boolean valid();
}
