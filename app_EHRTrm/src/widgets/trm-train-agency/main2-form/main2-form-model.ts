/**
 * Main2 部件模型
 *
 * @export
 * @class Main2Model
 */
export default class Main2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main2Model
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
        prop: 'trmtrainagencyid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtrainagencyname',
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
        name: 'trmtrainagencyname',
        prop: 'trmtrainagencyname',
        dataType: 'TEXT',
      },
      {
        name: 'jglx',
        prop: 'jglx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jgdj',
        prop: 'jgdj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jglb',
        prop: 'jglb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'trmtrainagencyname2',
        prop: 'trmtrainagencyname2',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'sfgx',
        prop: 'sfgx',
        dataType: 'YESNO',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'lxdh',
        prop: 'lxdh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'zcxx',
        prop: 'zcxx',
        dataType: 'TEXT',
      },
      {
        name: 'kctxfw',
        prop: 'kctxfw',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'kpmc',
        prop: 'kpmc',
        dataType: 'TEXT',
      },
      {
        name: 'kplx',
        prop: 'kplx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'nsrsbh',
        prop: 'nsrsbh',
        dataType: 'TEXT',
      },
      {
        name: 'khh',
        prop: 'khh',
        dataType: 'TEXT',
      },
      {
        name: 'khhzh',
        prop: 'khhzh',
        dataType: 'TEXT',
      },
      {
        name: 'kpr',
        prop: 'kpr',
        dataType: 'TEXT',
      },
      {
        name: 'kprdh',
        prop: 'kprdh',
        dataType: 'TEXT',
      },
      {
        name: 'kpdz',
        prop: 'kpdz',
        dataType: 'TEXT',
      },
      {
        name: 'jj',
        prop: 'jj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pj',
        prop: 'pj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmtrainagencyid',
        prop: 'trmtrainagencyid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainagency',
        prop: 'trmtrainagencyid',
        dataType: 'FONTKEY',
      },
    ]
  }

}