<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdgzmxGZCEditViewBase from './pcm-ydgzmx-gzcedit-view-base.vue';

import view_form from '@widgets/pcm-ydgzmx/xzgzcedit-form-form/xzgzcedit-form-form.vue';

/**
 * 新增挂职出
 *
 * @export
 * @class PcmYdgzmxGZCEditView
 * @extends {PcmYdgzmxGZCEditViewBase}
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
export default class PcmYdgzmxGZCEditView extends PcmYdgzmxGZCEditViewBase { }
</script>