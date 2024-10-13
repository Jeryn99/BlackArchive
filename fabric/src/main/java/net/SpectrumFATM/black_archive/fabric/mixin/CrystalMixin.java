package net.SpectrumFATM.black_archive.fabric.mixin;

import net.SpectrumFATM.black_archive.fabric.tardis.control.ModControls;
import net.minecraft.entity.EntityDimensions;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import whocraft.tardis_refined.common.tardis.control.ControlSpecification;
import whocraft.tardis_refined.common.tardis.themes.console.CrystalConsoleTheme;
import whocraft.tardis_refined.registry.TRControlRegistry;

@Mixin(CrystalConsoleTheme.class)
public abstract class CrystalMixin {

    @Inject(method = "getControlSpecification", at = @At("HEAD"), cancellable = true, remap = false)
    public ControlSpecification[] getControlSpecification(CallbackInfoReturnable<ControlSpecification[]> cir) {
        ControlSpecification[] s = new ControlSpecification[]{new ControlSpecification(TRControlRegistry.THROTTLE, new Vector3f(-0.735F, 1.13F, -0.45F), EntityDimensions.changing(0.25F, 0.25F)), new ControlSpecification(TRControlRegistry.X, new Vector3f(-0.7F, 0.5F, 0.93F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.Y, new Vector3f(-0.52F, 0.5F, 0.89F), EntityDimensions.changing(0.13F, 0.12F)), new ControlSpecification(TRControlRegistry.Z, new Vector3f(-0.45F, 0.5F, 1.05F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.INCREMENT, new Vector3f(-0.92F, 0.46F, 0.87F), EntityDimensions.changing(0.12F, 0.13F)), new ControlSpecification(TRControlRegistry.ROTATE, new Vector3f(-0.62F, 0.57F, -1.07F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.RANDOM, new Vector3f(-0.595F, 0.55F, 1.04F), EntityDimensions.changing(0.08F, 0.08F)), new ControlSpecification(TRControlRegistry.DOOR_TOGGLE, new Vector3f(1.18F, 0.52F, -0.35F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.MONITOR, new Vector3f(-0.0149F, 0.94F, 1.38F), EntityDimensions.changing(0.43F, 0.43F)), new ControlSpecification(TRControlRegistry.DIMENSION, new Vector3f(0.65F, 0.5F, -0.42F), EntityDimensions.changing(0.33F, 0.3F)), new ControlSpecification(TRControlRegistry.FAST_RETURN, new Vector3f(-0.29F, 0.39F, -1.21F), EntityDimensions.changing(0.25F, 0.25F)), new ControlSpecification(ModControls.TELEPATHIC, new Vector3f(1.11F, 0.56F, 0.11F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.11F, 0.56F, -0.16F), EntityDimensions.changing(0.13F, 0.12F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.61F, 0.56F, -0.96F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.68F, 0.56F, -1.08F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.29F, 0.56F, -1.28F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.52F, 0.61F, -0.74F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-1.03F, 0.64F, -0.52F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.81F, 0.64F, -0.01F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-1.14F, 0.51F, -0.38F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(-0.82F, 1.07F, 0.16F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.FUEL, new Vector3f(0.29F, 0.52F, 1.23F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.58F, 0.52F, 1.29F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.69F, 0.52F, 1.22F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(0.83F, 0.52F, 1.14F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.12F, 0.4F, -0.99F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.GENERIC_NO_SHOW, new Vector3f(1.12F, 0.4F, -0.99F), EntityDimensions.changing(0.13F, 0.13F)), new ControlSpecification(TRControlRegistry.HANDBRAKE, new Vector3f(0.685F, 1.13F, 0.37F), EntityDimensions.changing(0.25F, 0.25F)), new ControlSpecification(TRControlRegistry.READOUT, new Vector3f(0.83F, 1.06F, -0.56F), EntityDimensions.changing(0.13F, 0.13F))};
        cir.setReturnValue(s);
        return s;
    }
}