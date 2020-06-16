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
        prop: 'trmtrainbuapplyid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrainbuapplyname',
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
        name: 'trmtrainplantermid',
        prop: 'trmtrainplantermid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainplantermname',
        prop: 'trmtrainplantermname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'jflx',
        prop: 'jflx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'tzysxm',
        prop: 'tzysxm',
        dataType: 'TEXT',
      },
      {
        name: 'tzje',
        prop: 'tzje',
        dataType: 'FLOAT',
      },
      {
        name: 'clf',
        prop: 'clf',
        dataType: 'FLOAT',
      },
      {
        name: 'szf',
        prop: 'szf',
        dataType: 'FLOAT',
      },
      {
        name: 'cdzj',
        prop: 'cdzj',
        dataType: 'FLOAT',
      },
      {
        name: 'jgfy',
        prop: 'jgfy',
        dataType: 'FLOAT',
      },
      {
        name: 'qtfy',
        prop: 'qtfy',
        dataType: 'FLOAT',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmtrainbuapplyid',
        prop: 'trmtrainbuapplyid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainbuapply',
        prop: 'trmtrainbuapplyid',
        dataType: 'FONTKEY',
      },
    ]
  }

}