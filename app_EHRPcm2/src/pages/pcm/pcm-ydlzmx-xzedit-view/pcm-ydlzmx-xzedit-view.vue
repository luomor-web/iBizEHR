<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxXZEditViewBase from './pcm-ydlzmx-xzedit-view-base.vue';

import view_form from '@widgets/pcm-ydlzmx/main-form/main-form.vue';

/**
 * 新增离职
 *
 * @export
 * @class PcmYdlzmxXZEditView
 * @extends {PcmYdlzmxXZEditViewBase}
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
export default class PcmYdlzmxXZEditView extends PcmYdlzmxXZEditViewBase { }
</script>