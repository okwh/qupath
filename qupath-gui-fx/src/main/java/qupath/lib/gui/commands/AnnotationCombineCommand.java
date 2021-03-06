/*-
 * #%L
 * This file is part of QuPath.
 * %%
 * Copyright (C) 2014 - 2016 The Queen's University of Belfast, Northern Ireland
 * Contact: IP Management (ipmanagement@qub.ac.uk)
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

package qupath.lib.gui.commands;

import java.util.ArrayList;

import qupath.lib.gui.commands.interfaces.PathCommand;
import qupath.lib.gui.viewer.QuPathViewer;
import qupath.lib.roi.PathObjectToolsAwt;
import qupath.lib.roi.PathROIToolsAwt;

/**
 * Command to combine multiple annotations by merging their ROIs.
 * 
 * @author Pete Bankhead
 *
 */
public class AnnotationCombineCommand implements PathCommand {

	final private QuPathViewer viewer;
	final private PathROIToolsAwt.CombineOp op;

	public AnnotationCombineCommand(final QuPathViewer viewer, final PathROIToolsAwt.CombineOp op) {
		super();
		this.viewer = viewer;
		this.op = op;
	}

	@Override
	public void run() {
		PathObjectToolsAwt.combineAnnotations(viewer.getHierarchy(), new ArrayList<>(viewer.getHierarchy().getSelectionModel().getSelectedObjects()), op);
	}
	
}