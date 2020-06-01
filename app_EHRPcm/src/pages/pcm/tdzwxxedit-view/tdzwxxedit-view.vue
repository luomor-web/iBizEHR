<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TDZWXXEditViewBase from './tdzwxxedit-view-base.vue';

import view_form from '@widgets/pcm-tdzwxx/main-form/main-form.vue';

/**
 * 投递职位摘要信息
 *
 * @export
 * @class TDZWXXEditView
 * @extends {TDZWXXEditViewBase}
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
export default class TDZWXXEditView extends TDZWXXEditViewBase { }
</script>