<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYddgmxXZEditViewBase from './pcm-yddgmx-xzedit-view-base.vue';

import view_form from '@widgets/pcm-yddgmx/main-form/main-form.vue';

/**
 * 新增待岗
 *
 * @export
 * @class PcmYddgmxXZEditView
 * @extends {PcmYddgmxXZEditViewBase}
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
export default class PcmYddgmxXZEditView extends PcmYddgmxXZEditViewBase { }
</script>