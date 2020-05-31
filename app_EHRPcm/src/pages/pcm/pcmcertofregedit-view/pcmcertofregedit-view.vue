<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMCERTOFREGEditViewBase from './pcmcertofregedit-view-base.vue';

import view_form from '@widgets/pcm-certofreg/main-form/main-form.vue';

/**
 * 注册证书编辑视图
 *
 * @export
 * @class PCMCERTOFREGEditView
 * @extends {PCMCERTOFREGEditViewBase}
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
export default class PCMCERTOFREGEditView extends PCMCERTOFREGEditViewBase { }
</script>