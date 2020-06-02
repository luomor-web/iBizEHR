<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxXZEditViewBase from './pcm-ydntmx-xzedit-view-base.vue';

import view_form from '@widgets/pcm-ydntmx/main-form/main-form.vue';

/**
 * 新增内退
 *
 * @export
 * @class PcmYdntmxXZEditView
 * @extends {PcmYdntmxXZEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PcmYdntmxXZEditView extends PcmYdntmxXZEditViewBase { }
</script>