<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxEditViewBase from './pcm-ydbxmx-edit-view-base.vue';

import view_form from '@widgets/pcm-ydbxmx/main-form/main-form.vue';

/**
 * 异动病休明细编辑视图
 *
 * @export
 * @class PcmYdbxmxEditView
 * @extends {PcmYdbxmxEditViewBase}
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
export default class PcmYdbxmxEditView extends PcmYdbxmxEditViewBase { }
</script>