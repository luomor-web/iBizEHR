/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'trmtrainoutapplyid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrainoutapplyname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'zz',
        prop: 'zz',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'djbh',
        prop: 'djbh',
        dataType: 'TEXT',
      },
      {
        name: 'trmtrainoutapplyname',
        prop: 'trmtrainoutapplyname',
        dataType: 'TEXT',
      },
      {
        name: 'ywlx',
        prop: 'ywlx',
        dataType: 'TEXT',
      },
      {
        name: 'pxfs',
        prop: 'pxfs',
        dataType: 'TEXT',
      },
      {
        name: 'pxlb',
        prop: 'pxlb',
        dataType: 'TEXT',
      },
      {
        name: 'pxmb',
        prop: 'pxmb',
        dataType: 'TEXT',
      },
      {
        name: 'pxnr',
        prop: 'pxnr',
        dataType: 'TEXT',
      },
      {
        name: 'pxksrq',
        prop: 'pxksrq',
        dataType: 'DATE',
      },
      {
        name: 'pxjsrq',
        prop: 'pxjsrq',
        dataType: 'DATE',
      },
      {
        name: 'pxdd',
        prop: 'pxdd',
        dataType: 'TEXT',
      },
      {
        name: 'wbpxjg',
        prop: 'wbpxjg',
        dataType: 'TEXT',
      },
      {
        name: 'trmtrainoutapplyid',
        prop: 'trmtrainoutapplyid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainoutapply',
        prop: 'trmtrainoutapplyid',
        dataType: 'FONTKEY',
      },
    ]
  }

}