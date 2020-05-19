<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMJXSGZEditViewBase from './pcmjxsgzedit-view-base.vue';

import view_form from '@widgets/pcmjxsgz/main-form/main-form.vue';

/**
 * 见习期编辑视图
 *
 * @export
 * @class PCMJXSGZEditView
 * @extends {PCMJXSGZEditViewBase}
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
export default class PCMJXSGZEditView extends PCMJXSGZEditViewBase { }
</script>