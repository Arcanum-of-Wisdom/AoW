package net.minecraft.world.level.storage.loot.entries;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class EntryGroup extends CompositeEntryBase {
    public static final Codec<EntryGroup> CODEC = createCodec(EntryGroup::new);

    EntryGroup(List<LootPoolEntryContainer> p_298565_, List<LootItemCondition> p_298406_) {
        super(p_298565_, p_298406_);
    }

    @Override
    public LootPoolEntryType getType() {
        return LootPoolEntries.GROUP;
    }

    @Override
    protected ComposableEntryContainer compose(List<? extends ComposableEntryContainer> p_299019_) {
        return switch(p_299019_.size()) {
            case 0 -> ALWAYS_TRUE;
            case 1 -> (ComposableEntryContainer)p_299019_.get(0);
            case 2 -> {
                ComposableEntryContainer composableentrycontainer = p_299019_.get(0);
                ComposableEntryContainer composableentrycontainer1 = p_299019_.get(1);
                yield (p_79556_, p_79557_) -> {
                    composableentrycontainer.expand(p_79556_, p_79557_);
                    composableentrycontainer1.expand(p_79556_, p_79557_);
                    return true;
                };
            }
            default -> (p_298014_, p_298015_) -> {
            for(ComposableEntryContainer composableentrycontainer2 : p_299019_) {
                composableentrycontainer2.expand(p_298014_, p_298015_);
            }

            return true;
        };
        };
    }

    public static EntryGroup.Builder list(LootPoolEntryContainer.Builder<?>... p_165138_) {
        return new EntryGroup.Builder(p_165138_);
    }

    public static class Builder extends LootPoolEntryContainer.Builder<EntryGroup.Builder> {
        private final ImmutableList.Builder<LootPoolEntryContainer> entries = ImmutableList.builder();

        public Builder(LootPoolEntryContainer.Builder<?>... p_165141_) {
            for(LootPoolEntryContainer.Builder<?> builder : p_165141_) {
                this.entries.add(builder.build());
            }
        }

        protected EntryGroup.Builder getThis() {
            return this;
        }

        @Override
        public EntryGroup.Builder append(LootPoolEntryContainer.Builder<?> p_165145_) {
            this.entries.add(p_165145_.build());
            return this;
        }

        @Override
        public LootPoolEntryContainer build() {
            return new EntryGroup(this.entries.build(), this.getConditions());
        }
    }
}
