package net.SpectrumFATM.black_archive.mixin;

import net.SpectrumFATM.black_archive.tardis.control.ModControls;
import net.minecraft.entity.EntityDimensions;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.CopperConsoleTheme;
import whocraft.tardis_refined.registry.TRControlRegistry;

@Mixin(CopperConsoleTheme.class)
public abstract class CopperMixin {

    @Inject(method = "getControlSpecification", at = @At("HEAD"), cancellable = true, remap = false)
    public ControlSpecification[] getControlSpecification(CallbackInfoReturnable<ControlSpecification[]> cir) {
        ControlSpecification[] s = new ControlSpecification[]{new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(0.11F, 0.69F, -1.26F), EntityDimensions.changing(0.19F, 0.19F)), new ControlSpecification(TRControlRegistry.X, new Vector3f(0.68F, 0.97F, 0.14F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.Y, new Vector3f(0.68F, 0.97F, -0.01F), EntityDimensions.changing(0.13F, 0.12F)), new ControlSpecification(TRControlRegistry.Z, new Vector3f(0.68F, 0.97F, -0.17F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(1.19F, 0.51F, -0.26F), EntityDimensions.changing(0.13F, 0.12F)), new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(0.74F, 0.5F, 0.93F), EntityDimensions.changing(0.19F, 0.19F)), new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(0.68F, 0.25F, -1.26F), EntityDimensions.changing(0.19F, 0.19F)), new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(-0.2F, 0.63F, -1.26F), EntityDimensions.changing(0.19F, 0.19F)), new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(0.89F, 1.39F, -0.515F), EntityDimensions.changing(0.45F, 0.4F)), new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(0.35F, 0.63F, 1.11F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(-0.79F, 0.53F, -0.95F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(ModControls.TELEPATHIC, new Vector3f(0.71F, 0.47F, -0.91F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.02F, 0.63F, -0.25F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.23F, 0.57F, -0.0F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.23F, 0.57F, 0.27F), EntityDimensions.changing(0.13F, 0.12F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.23F, 0.57F, 0.54F), EntityDimensions.changing(0.13F, 0.12F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.1F, 0.69F, 0.47F), EntityDimensions.changing(0.13F, 0.12F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.04F, 0.69F, 0.79F), EntityDimensions.changing(0.13F, 0.12F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.13F, 0.82F, 0.97F), EntityDimensions.changing(0.13F, 0.12F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.09F, 0.6F, 1.19F), EntityDimensions.changing(0.19F, 0.19F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.19F, 0.76F, 1.03F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-1.06F, 0.57F, 0.75F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.96F, 0.69F, 0.69F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.74F, 0.76F, 0.56F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.36F, 1.06F, 0.65F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-1.25F, 0.57F, 0.51F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-1.0F, 0.76F, 0.39F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-1.21F, 0.57F, 0.05F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-1.21F, 0.64F, -0.28F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.49F, 0.54F, -1.09F), EntityDimensions.changing(0.12F, 0.13F)), new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(-1.2F, 0.63F, -0.57F), EntityDimensions.changing(0.25F, 0.25F)), new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(0.24F, 0.97F, -0.7F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(0.55F, 1.0F, -0.51F), EntityDimensions.changing(0.13F, 0.13F))};
        cir.setReturnValue(s);
        return s;
    }
}