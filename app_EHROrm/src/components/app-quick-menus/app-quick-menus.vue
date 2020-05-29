<template>
  <div class="app-menus">
    <template v-for="(item,index) in menus">
      <card :bordered="false" dis-hover v-if="item.items && Array.isArray(item.items)" :key="index">
        <p slot="title" @click="$emit('menuClick',item.name, [item.name])">
          <span style="margin-right:12px">
            <img :src="item.icon" v-if="!Object.is(item.icon, '')" />
            <img :src="item.iconcls" v-else-if="!Object.is(item.iconcls, '')" />
            <i class="fa fa-cogs" v-else></i>
          </span>
          <span>{{$t(`app.menus.${ctrlName}.${item.name}`)}}</span>
          <span class="line"></span>
        </p>
        <p style=" display: 'flex' ">
          <app-quick-menus :menus="item.items" :ctrlName = "ctrlName"></app-quick-menus>
        </p>
      </card>
      <card
        :key="index"
        :style=" {
            width:'24%',
            height: '50px',
            wordBreak: 'break-all',
            cursor: 'pointer',
            margin: '6px',
            border:'0',
            padding:'8px',
            display: 'flex',
            alignItems: 'center'
        }"
        :padding="0"
        v-else
      >
        <div @click="$emit('menuClick',item.name, [item.name])">
          <span style="margin-right:12px">
            <img :src="item.icon" v-if="!Object.is(item.icon, '')" />
            <img :src="item.iconcls" v-else-if="!Object.is(item.iconcls, '')" />
            <i class="fa fa-cogs" v-else></i>
          </span>
          <h4>{{$t(`app.menus.${ctrlName}.${item.name}`)}}</h4>
        </div>
      </card>
    </template>
  </div>
</template>

<script lang='ts'>
import { Component, Vue, Prop, Model, Watch } from "vue-property-decorator";

@Component({})
export default class AppQuickMenus extends Vue {
  /**
   * 菜单数据
   *
   * @type {*}
   * @memberof AppQuickMenus
   */
  @Prop({ default: [] }) public menus!: any;

  /**
   * 部件名称
   * 
   * @type {String}
   * @memberof AppQuickMenus
   */
  @Prop() public ctrlName!:String;
}
</script>

<style lang='less'>
@import "./app-quick-menus.less";
</style>